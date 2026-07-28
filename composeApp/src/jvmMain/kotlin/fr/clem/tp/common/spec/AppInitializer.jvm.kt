package fr.clem.tp.common.spec

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual object AppInitializer {
    actual fun init() {
        initLogging()
    }

    private fun initLogging() {
        Napier.base(DebugAntilog())
    }
}