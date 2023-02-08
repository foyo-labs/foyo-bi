package com.foyo.bi.core.executor

import org.apache.calcite.rel.RelNode
import org.apache.calcite.tools.RelRunners
import java.lang.Exception
import java.sql.ResultSet

interface IQueryExecutor{

}

open abstract class QueryExecutor: IQueryExecutor {

  fun execute(): ResultSet {
    try {
      return QueryContext.use { ctx ->
        //TODO..
        RelRunners.run(null).executeQuery()
      }
    } catch (e: Exception) {
      //TODO ..
      throw e
    }
  }
}
