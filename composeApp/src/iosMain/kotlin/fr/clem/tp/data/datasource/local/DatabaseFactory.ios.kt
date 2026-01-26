package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import fr.clem.tp.MyDatabase
import platform.Foundation.*

actual class DatabaseFactory : DatabaseFactoryPlatform {

    override fun createDbDriver(): SqlDriver {
        val documents = NSSearchPathForDirectoriesInDomains(
            directory = NSDocumentDirectory,
            domainMask = NSUserDomainMask,
            expandTilde = true
        ).first() as String

        val path = "$documents/tp.db"
        return NativeSqliteDriver(MyDatabase.Schema, path)
    }
}