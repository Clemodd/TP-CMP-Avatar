package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import fr.clem.tp.MyDatabase

actual class DatabaseFactory : DatabaseFactoryPlatform {

    override fun createDbDriver(): SqlDriver =
        NativeSqliteDriver(MyDatabase.Schema, "tp.db")
}