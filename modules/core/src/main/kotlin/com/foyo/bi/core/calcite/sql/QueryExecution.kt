package com.foyo.bi.core.calcite.sql

import com.foyo.bi.core.FoyoContext
import org.apache.calcite.tools.RelRunners
import java.sql.ResultSet

class QueryExecution(private val statement: String) {

  private val planner = FoyoContext.sqlPlanner

  fun execute(): ResultSet{
    try {
      return QueryContext.use { ctx ->
        ctx.statement = statement
        val plan = planner.parse(statement).relOpt
        RelRunners.run(plan).executeQuery()
      }
    } catch (e: Exception) {
      throw e
    }
  }

}
