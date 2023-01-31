package com.foyo.bi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class User (@Id val id: Int?, val name: String)
