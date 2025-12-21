package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver

interface DatabaseFactoryPlatform {
    fun createDbDriver(): SqlDriver
}

expect class DatabaseFactory