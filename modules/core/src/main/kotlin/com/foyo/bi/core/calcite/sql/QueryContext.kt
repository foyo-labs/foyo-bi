package com.foyo.bi.core.calcite.sql

import com.foyo.bi.core.SessionId
import org.apache.calcite.sql.SqlNode
import org.apache.calcite.sql.SqlSelect
import java.io.Serializable

class QueryContext: Serializable {
  var statement: String? = null
  var originalPlan: SqlNode? = null
  var currentSelectNode: SqlSelect? = null
  @Volatile var sessionId: SessionId? = null

  companion object {
    private val context = object : ThreadLocal<QueryContext>() {
      override fun initialValue(): QueryContext = QueryContext()
    }

    fun get(): QueryContext = context.get()

    fun reset() = context.remove()

    fun <T> use(block: (QueryContext) -> T): T {
      try {
        reset()
        return block(get())
      } finally {
        reset()
      }
    }
  }
}
