package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import fr.clem.tp.MyDatabase

actual class DatabaseFactory : DatabaseFactoryPlatform {

    override fun createDbDriver(): SqlDriver =
        JdbcSqliteDriver("jdbc:sqlite:tp.db").also {
            MyDatabase.Schema.create(it)
        }
}
