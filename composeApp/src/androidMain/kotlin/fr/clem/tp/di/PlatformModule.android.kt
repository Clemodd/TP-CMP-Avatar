package fr.clem.tp.di

import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import fr.clem.tp.MyDatabase
import fr.clem.tp.common.spec.HapticFeedback
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule = module {

    single<MyDatabase> {
        MyDatabase(
            driver = AndroidSqliteDriver(
                schema = MyDatabase.Schema,
                context = androidContext(),
                name = "tp.db"
            )
        )
    }

    single { HapticFeedback(androidContext()) }
}