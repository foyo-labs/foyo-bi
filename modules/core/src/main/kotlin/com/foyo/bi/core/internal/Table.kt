package com.foyo.bi.core.internal

data class Table(
  val tableNames: List<String>,
  val rowCount: Int,
  val columns: List<TablePrinter.Column>,
) {

  fun show() {
    TablePrinter.print(this)
  }
}
