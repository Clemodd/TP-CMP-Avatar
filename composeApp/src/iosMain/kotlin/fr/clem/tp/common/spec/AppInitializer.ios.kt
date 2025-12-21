package fr.clem.tp.common.spec

import fr.clem.tp.di.initKoin
import io.github.aakira.napier.Napier

actual object AppInitializer {
    actual fun init() {
        initKoin()
        initLogging()
    }

    private fun initLogging() {
        Napier.base(NSLogAntilog()) // TODO : import
    }
}