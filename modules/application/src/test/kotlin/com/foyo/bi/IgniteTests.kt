package com.foyo.bi

import org.apache.ignite.Ignite
import org.apache.ignite.IgnitionManager
import org.apache.ignite.app.IgniteRunner
import org.apache.ignite.client.IgniteClient
import org.apache.ignite.compute.ComputeJob
import org.apache.ignite.compute.JobExecutionContext
import org.junit.jupiter.api.Test
import java.nio.file.Path
import java.util.concurrent.CompletableFuture


class IgniteTests {

  @Test
  fun test_connection_host() {
    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
    print(client)
  }

  @Test
  fun ignite_init() {

    val path = System.getProperty("user.dir")

    val configPath =
      Path.of(IgniteTests::class.java.getResource("/ignite-config-rest-port-not-default.json").toURI())
    val ign: CompletableFuture<Ignite> = IgniteRunner.start(
      "--config-path", configPath.toAbsolutePath().toString(),
      "--work-dir", "$path/work/ignite/",
      "--node-name", "node"
    )
    IgnitionManager.init("node", listOf("node"), "cluster");

//    val client = IgniteClient.Builder().addresses("127.0.0.1:10800").build()
//    val computer = client.compute()
//    val nodes: Set<ClusterNode> = HashSet(client.clusterNodes())
//    computer.execute(nodes, SimpleComputer::class.java, "hello", "word")
  }
}

class SimpleComputer : ComputeJob<String> {
  override fun execute(context: JobExecutionContext?, vararg args: Any?): String? {
    print("ignite computer....")
    return args.joinToString(truncated = ",")
  }
}

