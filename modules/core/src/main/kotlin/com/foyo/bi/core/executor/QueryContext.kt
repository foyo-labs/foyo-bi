package com.foyo.bi.core.executor

import java.io.Serializable

class QueryContext: Serializable {
  var statement: String? = null

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
