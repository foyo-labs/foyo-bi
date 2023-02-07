package com.foyo.bi.core.calcite.sql

import org.apache.calcite.rel.RelNode

data class SqlPlan(
  val statement: String,
  val rel: RelNode?,
  val relOpt: RelNode?,
) {

  fun explain(): String {
    return this.relOpt?.explain() ?: "NOT"
  }
}
