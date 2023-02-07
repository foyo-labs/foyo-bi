package com.foyo.bi.core

import com.foyo.bi.core.calcite.sql.SqlPlanner
import java.util.*

object FoyoContext {

  val catalog by lazy {

  }
  val sqlPlanner by lazy {
      SqlPlanner()
  }


}


data class SessionId(
  val id: UUID
){
  companion object {
    fun fakeSessionId(): SessionId {
      return SessionId(UUID.randomUUID())
    }
  }
}
data class SessionContext(
  val sessionId: SessionId,
){
  companion object {

  }
}
