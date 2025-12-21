package fr.clem.tp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import fr.clem.tp.common.spec.AppInitializer

fun main() = application {
    AppInitializer.init()

    Window(
        onCloseRequest = ::exitApplication,
        title = "TP",
    ) {
        App()
    }
}