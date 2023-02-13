package com.foyo.bi.core.calcite.sql

import com.foyo.bi.core.FoyoContext
import com.foyo.bi.core.SessionId
import com.foyo.bi.sdk.exception.FoyoException
import org.apache.calcite.tools.RelRunners
import java.sql.ResultSet

class QueryExecution(private val statement: String, private val sessionId: SessionId) {

  private val planner = FoyoContext.sqlPlanner

  fun execute(): ResultSet {
    try {
      return QueryContext.use { ctx ->
        ctx.statement = statement
        ctx.sessionId = sessionId
        val plan = planner.parse(statement)?.relOpt
        RelRunners.run(plan).executeQuery()
      }
    } catch (e: Throwable) {
      when (e) {
        is FoyoException -> throw e
        else -> throw FoyoException(statement, e)
      }
    }
  }
}
