package fr.clem.tp

import androidx.compose.ui.window.ComposeUIViewController
import fr.clem.tp.di.initKoin
import platform.Foundation.NSLog

fun MainViewController() = ComposeUIViewController(
    configure = {
        try {
            initKoin()
            NSLog("KOIN INIT SUCCESS")
        } catch (e: Throwable) {
            NSLog("KOIN INIT ERROR: %@", e.message ?: "unknown")
            NSLog("KOIN INIT CAUSE: %@", e.cause?.message ?: "unknown")
            NSLog("KOIN INIT STACK: %@", e.stackTraceToString())
            throw e
        }
    }
) {
        App()
}