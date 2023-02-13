package com.foyo.bi.repository

import com.foyo.bi.db.DatabaseFactory
import org.koin.core.component.KoinComponent

class UserRepository(private val db: DatabaseFactory): KoinComponent {

}

