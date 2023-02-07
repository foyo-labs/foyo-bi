package com.foyo.bi.core.calcite.sql

class SqlPlanner {

  fun parse(statement: String): SqlPlan {
    // TODO parser sql to sql node
    return SqlPlan(statement, null, null);
  }
}
