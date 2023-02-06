package com.foyo.bi.sdk.pipeline.filter

/**
 * 过滤器，需要实现数据装载端、和计算管道端的过滤器。
 */
interface Filter {
  fun filter()
}
