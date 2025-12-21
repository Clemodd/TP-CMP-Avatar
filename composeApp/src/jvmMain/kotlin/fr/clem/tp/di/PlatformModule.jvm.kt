package fr.clem.tp.di

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import fr.clem.tp.MyDatabase
import fr.clem.tp.common.spec.HapticFeedback
import org.koin.dsl.module

actual val platformModule = module {

    single<MyDatabase> {
        val driver = JdbcSqliteDriver("jdbc:sqlite:tp.db")

        try {
            MyDatabase.Schema.create(driver)
        } catch (_: Exception) {
            // DB déjà créée → OK
        }

        MyDatabase(driver)
    }


    single { HapticFeedback() }
}