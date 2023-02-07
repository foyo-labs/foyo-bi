package com.foyo.bi.core.calcite.internal

import java.sql.ResultSet
import java.sql.Types

object TablePrinter {
  private const val DEFAULT_MAX_TEXT_COL_WIDTH = 150
  private const val DEFAULT_MAX_ROWS = 10
  private const val CATEGORY_STRING = 1
  private const val CATEGORY_INTEGER = 2
  private const val CATEGORY_DOUBLE = 3
  private const val CATEGORY_DATETIME = 4
  private const val CATEGORY_BOOLEAN = 5
  private const val CATEGORY_OTHER = 0

  data class Column(
    val label: String,
    val type: Int,
    val typeName: String,
    var width: Int = 0,
    val values: MutableList<String?> = mutableListOf(),
    val typeValues: MutableList<Any?> = mutableListOf(),
    var justifyFlag: String = "",
    var typeCategory: Int = 0
  ) {
    fun justifyLeft() {
      this.justifyFlag = "-"
    }
  }

  @JvmStatic
  @JvmOverloads
  fun from(rs: ResultSet, maxStringColWidth: Int = DEFAULT_MAX_TEXT_COL_WIDTH): Table {
    val rsmd = rs.metaData
    val columnCount = rsmd.columnCount
    val columns = ArrayList<Column>(columnCount)
    val tableNames = ArrayList<String>(columnCount)
    for (i in 1..columnCount) {
      val c = Column(rsmd.getColumnLabel(i), rsmd.getColumnType(i), rsmd.getColumnTypeName(i))
      c.width = c.label.length
      c.typeCategory = whichCategory(c.type)
      columns.add(c)
      if (!tableNames.contains(rsmd.getTableName(i))) {
        tableNames.add(rsmd.getTableName(i))
      }
    }
    var rowCount = 0
    while (rs.next()) {
      for (i in 0 until columnCount) {
        val c = columns[i]
        var value = if (c.typeCategory == CATEGORY_OTHER) {
          "(" + c.typeName + ")"
        } else {
          if (rs.getObject(i + 1) == null) "NULL" else rs.getObject(i + 1).toString()
        }
        when (c.typeCategory) {
          CATEGORY_DOUBLE ->
            if (value != "NULL") {
              val dValue = rs.getDouble(i + 1)
              value = String.format("%.3f", dValue)
            }

          CATEGORY_STRING -> {
            c.justifyLeft()
            if (value.length > maxStringColWidth) {
              value = value.substring(0, maxStringColWidth - 3) + "..."
            }
          }
        }
        c.width = if (value.length > c.width) value.length else c.width
        c.values.add(value)
        c.typeValues.add(rs.getObject(i + 1))
      }
      rowCount++
    }
    return Table(tableNames, rowCount, columns)
  }

  @JvmStatic
  fun print(table: Table?) {
    if (table == null) {
      return
    }
    val tableNames = table.tableNames
    val rowCount = table.rowCount
    val columns = table.columns
    val strToPrint = StringBuilder()
    val rowSeparator = StringBuilder()
    columns.forEach { c ->
      var width = c.width
      val name: String = c.label
      var diff = width - name.length

      if (diff % 2 == 1) {
        width++
        diff++
        c.width = width
      }
      val paddingSize = diff / 2
      val padding = String(CharArray(paddingSize)).replace("\u0000", " ")

      val toPrint = "| $padding$name$padding "
      strToPrint.append(toPrint)
      rowSeparator.append("+")
      rowSeparator.append(String(CharArray(width + 2)).replace("\u0000", "-"))
    }
    var lineSeparator = System.getProperty("line.separator")
    lineSeparator = lineSeparator ?: "\n"

    rowSeparator.append("+").append(lineSeparator)

    strToPrint.append("|").append(lineSeparator)
    strToPrint.insert(0, rowSeparator)
    strToPrint.append(rowSeparator)

    val sj = tableNames.joinToString(", ")

    var info = "Printing $rowCount"
    info += if (rowCount > 1) " rows from " else " row from "
    info += if (tableNames.size > 1) "tables " else "table "
    info += sj

    println(info)
    print(strToPrint.toString())

    var format: String
    for (i in 0 until rowCount) {
      columns.forEach { c ->
        format = String.format("| %%%s%ds ", c.justifyFlag, c.width)
        print(String.format(format, c.values[i]))
      }
      println("|")
      print(rowSeparator)
    }
    println()
  }

  private fun whichCategory(type: Int): Int {
    return when (type) {
      Types.BIGINT, Types.TINYINT, Types.SMALLINT, Types.INTEGER ->
        CATEGORY_INTEGER
      Types.REAL, Types.DOUBLE, Types.DECIMAL ->
        CATEGORY_DOUBLE
      Types.DATE, Types.TIME, Types.TIME_WITH_TIMEZONE, Types.TIMESTAMP, Types.TIMESTAMP_WITH_TIMEZONE ->
        CATEGORY_DATETIME
      Types.BOOLEAN ->
        CATEGORY_BOOLEAN
      Types.VARCHAR, Types.NVARCHAR, Types.LONGVARCHAR, Types.LONGNVARCHAR, Types.CHAR, Types.NCHAR ->
        CATEGORY_STRING
      else -> CATEGORY_OTHER
    }
  }
}
