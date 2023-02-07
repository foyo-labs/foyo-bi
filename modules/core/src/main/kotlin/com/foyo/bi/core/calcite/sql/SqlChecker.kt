package com.foyo.bi.core.calcite.sql

import com.foyo.bi.core.SessionId
import com.foyo.bi.core.calcite.extensions.toTable
import com.foyo.bi.core.calcite.internal.Table

interface SqlChecker {

  fun sql(statement: String): SqlResult {
    val rs = QueryExecution(statement, SessionId.fakeSessionId()).execute()
    return SqlResult(statement, rs.toTable())
  }

  fun checkRows(statement: String, rows: List<List<Any?>>) {
    val result = sql(statement).result
    try {
      result.size == rows.size
      result.zip(rows).forEach { (r1, r2) ->
        r1.size == r2.size
        r1.zip(r2).forEach { (v1, v2) ->
          v1 == v2
        }
      }
    } catch (e: Throwable) {
      throw e
    }
  }
}

class SqlResult(private val statement: String, private val table: Table) {

  internal val result: List<List<Any?>> by lazy {
    mutableListOf<List<Any?>>().apply {
      (0 until table.rowCount).forEach { r ->
        add(table.columns.map { it.typeValues[r] })
      }
    }
  }

  val size = this.result.size

  fun show(): SqlResult {
    table.show()
    return this
  }
  override fun toString(): String {
    return this.result.toString()
  }

  override fun hashCode(): Int {
    return this.result.hashCode()
  }

  override fun equals(other: Any?): Boolean {
    return this.result == other
  }
}



