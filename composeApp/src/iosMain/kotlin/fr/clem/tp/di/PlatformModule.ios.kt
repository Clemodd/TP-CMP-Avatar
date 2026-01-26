package fr.clem.tp.di

import app.cash.sqldelight.db.SqlDriver
import fr.clem.tp.MyDatabase
import org.koin.dsl.module

actual val platformModule = module {

    single<SqlDriver> { DatabaseFactory().createDbDriver() }

    single<MyDatabase> { MyDatabase(driver = get()) }

    single { HapticFeedback() }
}
