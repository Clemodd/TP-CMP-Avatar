package fr.clem.tp.common.spec

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.component.KoinComponent

actual object AppInitializer : KoinComponent {

    actual fun init() {
        // TODO TP2.1 : appeler initKoin
        initLogging()
    }

    private fun initLogging() {
        Napier.base(DebugAntilog())
    }
}