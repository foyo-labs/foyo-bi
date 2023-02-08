package com.foyo.bi.core.executor

import org.jetbrains.kotlinx.dataframe.DataFrame

class ExecutionContext(val settings: Map<String, String>, private val dsType: DsType) {

  private val executor: QueryExecutor = when(dsType){
    DsType.Csv -> createCsvExecutor()
    else -> throw IllegalStateException()
  }

  private fun createCsvExecutor(): CsvQueryExecutor{
    return CsvQueryExecutor(mapOf())
  }

  fun execute(){
    executor.execute()
  }

}
