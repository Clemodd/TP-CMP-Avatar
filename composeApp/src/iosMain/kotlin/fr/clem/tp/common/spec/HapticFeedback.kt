package fr.clem.tp.common.spec

actual class HapticFeedback {
    actual fun vibrateLight() {
        val generator = UINotificationFeedbackGenerator()
        generator.notificationOccurred(UINotificationFeedbackTypeWarning)
    }
}