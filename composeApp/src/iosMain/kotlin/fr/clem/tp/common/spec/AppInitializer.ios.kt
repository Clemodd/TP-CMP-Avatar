package fr.clem.tp.common.spec

import fr.clem.tp.di.initKoin
import io.github.aakira.napier.Napier
import io.github.aakira.napier.NSLogAntilog

actual object AppInitializer {
    actual fun init() {
        initKoin()
        initLogging()
    }

    private fun initLogging() {
        Napier.base(NSLogAntilog())
    }
}