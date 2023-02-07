package com.foyo.bi.core.calcite.extensions

import com.foyo.bi.core.calcite.internal.Table
import com.foyo.bi.core.calcite.internal.TablePrinter
import java.sql.ResultSet

fun ResultSet.toListOfMaps(): MutableList<MutableMap<String, Any>> {
  val md = this.metaData
  val columns = md.columnCount
  val rows: MutableList<MutableMap<String, Any>> = ArrayList()
  while (this.next()) {
    val row: MutableMap<String, Any> = HashMap(columns)
    for (i in 1..columns) {
      row[md.getColumnLabel(i)] = this.getObject(i)
    }
    rows.add(row)
  }
  return rows
}

/**
 * TODO, SQL ResultSet to Arrow format.
 */
fun ResultSet.toArrow() {

}

fun ResultSet.toTable(): Table{
  return TablePrinter.from(this)
}
