package com.foyo.bi.sdk.exception

open class FoyoException @JvmOverloads constructor(msg: String, cause: Throwable? = null) : RuntimeException(msg, cause)
open class SQLExecutedException @JvmOverloads constructor(msg: String, cause: Throwable? = null) : FoyoException(msg, cause)
