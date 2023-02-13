package com.foyo.bi.core

import com.foyo.bi.core.calcite.sql.FoyoSqlPlanner
import java.util.*

object FoyoContext {

  val sqlPlanner by lazy {
    FoyoSqlPlanner()
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
