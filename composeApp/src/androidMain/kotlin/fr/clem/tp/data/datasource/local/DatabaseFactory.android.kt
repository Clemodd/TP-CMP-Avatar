package fr.clem.tp.data.datasource.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver

// TODO TP2.3 : expect/actual
class DatabaseFactory(private val context: Context) : DatabaseFactoryPlatform {

    // TODO TP2.3 : driver SQLDelight
    override fun createDbDriver(): SqlDriver = TODO()
}