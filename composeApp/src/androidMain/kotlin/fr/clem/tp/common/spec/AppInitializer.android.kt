package fr.clem.tp.common.spec

import fr.clem.tp.di.initKoin
import fr.clem.tp.MyApplication
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

actual object AppInitializer : KoinComponent {

    actual fun init() {
        initKoin { androidContext(androidContext = MyApplication.instance) }
        initLogging()
    }

    private fun initLogging() {
        Napier.base(DebugAntilog())
    }
}