package com.foyo.bi

import org.apache.ignite.client.IgniteClient

import org.apache.ignite.network.ClusterNode
import org.junit.jupiter.api.Test
import com.foyo.bi.driver.ignite.SimpleComputer
import java.util.concurrent.TimeUnit

class IgniteTests {

  @Test
  fun test_connection_host() {
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
    print(client)
  }

  @Test
  fun test_create_table(){
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
//    client.sql().createSession().executeBatch().execute(null, "INSERT INTO CITIES()").close()
  }

  @Test
  fun test_insert_data(){
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
    client.sql().createSession().execute(null, "CREATE TABLE CITIES (ID INT PRIMARY KEY, NAME VARCHAR)").close()
  }



  @Test
  fun test_query_table(){
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
    val rs = client.sql().createSession().execute(null, "select * from person")
    while (rs.hasNext()){
      val row = rs.next()
      val name = row.stringValue("CITY")
      println("rs: $name")
    }
  }
  @Test
  fun ignite_init() {
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
    val nodes: Set<ClusterNode> = HashSet(client.clusterNodes())
    val future = client.compute().execute(nodes, SimpleComputer::class.java, "hello", "word")
    future.thenAccept { res ->  println(res)}
    // no result?
  }
}

