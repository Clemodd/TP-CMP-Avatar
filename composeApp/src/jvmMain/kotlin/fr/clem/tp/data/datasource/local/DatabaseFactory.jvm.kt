package fr.clem.tp.data.datasource.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import fr.clem.tp.MyDatabase

// TODO TP2.3 : expect/actual
class DatabaseFactory : DatabaseFactoryPlatform {

    override fun createDbDriver(): SqlDriver =
        JdbcSqliteDriver("jdbc:sqlite:tp.db").also {
            MyDatabase.Schema.create(it)
        }
}
