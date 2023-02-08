package com.foyo.bi.core.extensions

import com.foyo.bi.core.internal.Table
import com.foyo.bi.core.internal.TablePrinter
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
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

fun ResultSet.toDataFrame(): DataFrame<*> {
  val cols = with(metaData) {
    (1 .. columnCount)
      .map { getColumnName(it) }
      .toList()
  }

  val resultList = sequence {
    while (this@toDataFrame.next()) {
      val mapRepoOfObject = mutableMapOf<String,Any>()
      cols.forEach() {
        mapRepoOfObject[it] = getObject(it)
      }
      yield(mapRepoOfObject)
    }
  }.toList()

  return dataFrameOf(cols){ header ->
    resultList.map { it[header]!! }.toList()
  }
}

fun ResultSet.toTable(): Table {
  return TablePrinter.from(this)
}
