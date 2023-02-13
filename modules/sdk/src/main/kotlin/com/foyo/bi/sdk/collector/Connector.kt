package com.foyo.bi.sdk.collector

/**
 * JDBC 连接器, 从数据库装载数据，附带属性为多个数据过滤器
 * 类型驱动、语法转换器
 */
interface Collector {
  /**
   * 初始化驱动
   */
  fun setUp()

  /**
   * 装载数据
   */
  fun load()
}
