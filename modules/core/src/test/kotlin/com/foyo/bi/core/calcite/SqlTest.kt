package com.foyo.bi.core.calcite

import com.foyo.bi.core.internal.TablePrinter
import io.kotest.core.spec.style.StringSpec
import org.apache.calcite.adapter.csv.CsvSchema
import org.apache.calcite.adapter.csv.CsvTable
import org.apache.calcite.adapter.jdbc.JdbcSchema
import org.apache.calcite.jdbc.CalciteConnection
import org.apache.calcite.rel.RelNode
import org.apache.calcite.tools.FrameworkConfig
import org.apache.calcite.tools.Frameworks
import org.apache.calcite.tools.RelBuilder
import org.apache.calcite.tools.RelRunners
import java.io.File
import java.sql.DriverManager
import java.util.*


/**
 * Using otest, It's necessary to install kotest intellij plugin
 */
class SqlTest: StringSpec() {

  init {
    "use calcite load simple csv data" {
      val path = Objects.requireNonNull(this::class.java.classLoader.getResource("csv").path)
      val csvSchema = CsvSchema(File(path), CsvTable.Flavor.SCANNABLE)
      val info = Properties()
      info.setProperty("caseSensitive", "false")
      val connection = DriverManager.getConnection("jdbc:calcite:", info)
      val calciteConnection = connection.unwrap(CalciteConnection::class.java)
      val rootSchema = calciteConnection.rootSchema
      rootSchema.add("csv", csvSchema)
      val sql = "select * from CSV.DEPTS"
      val rs = calciteConnection.createStatement().executeQuery(sql)
      TablePrinter.from(rs).show()
    }

    "use calcite load postgresql data" {
      val info = Properties()
      info.setProperty("caseSensitive", "false")
      val connection = DriverManager.getConnection("jdbc:calcite:", info)
      val calciteConnection = connection.unwrap(CalciteConnection::class.java)
      val rootSchema = calciteConnection.rootSchema
      val ds = JdbcSchema.dataSource(
        "jdbc:postgresql://localhost:5432/foyo_bi_db",
        "org.postgresql.Driver",
        "postgres",
        "");
      rootSchema.add("DB1", JdbcSchema.create(rootSchema, "DB1", ds, null, null));
      val rs = connection.createStatement().executeQuery("select * from db1.\"users\"")
      TablePrinter.from(rs).show()
    }
  }
}
