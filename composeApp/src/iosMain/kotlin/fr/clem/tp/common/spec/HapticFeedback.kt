package fr.clem.tp.common.spec

import platform.UIKit.*

actual class HapticFeedback {

    actual fun vibrateLight() {
        val generator = UIImpactFeedbackGenerator(style = UINotificationFeedbackTypeWarning)
        generator.prepare()
        generator.impactOccurred()
    }
}
