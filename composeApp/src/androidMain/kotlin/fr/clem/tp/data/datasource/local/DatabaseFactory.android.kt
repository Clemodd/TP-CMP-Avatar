package fr.clem.tp.data.datasource.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import fr.clem.tp.MyDatabase

actual class DatabaseFactory(private val context: Context) : DatabaseFactoryPlatform {

    override fun createDbDriver(): SqlDriver =
        AndroidSqliteDriver(MyDatabase.Schema, context, "tp.db")
}