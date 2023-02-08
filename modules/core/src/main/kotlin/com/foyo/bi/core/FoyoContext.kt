package com.foyo.bi.core

import java.util.*

object FoyoContext {

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
