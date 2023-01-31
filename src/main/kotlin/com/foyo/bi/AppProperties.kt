package com.foyo.bi

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "foyo.bi")
@ConstructorBinding
data class AppProperties(
  val version: String = "1.0.0"
)
