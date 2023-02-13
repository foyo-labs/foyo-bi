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
      // TODO ...
    }
    return Table(tableNames, rowCount, columns)
  }

  @JvmStatic
  fun print(table: Table?) {
    // TODO..
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
