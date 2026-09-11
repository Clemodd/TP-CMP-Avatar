package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver

interface DatabaseFactoryPlatform {
    fun createDbDriver(): SqlDriver
}

// TODO TP2.3 : DatabaseFactory