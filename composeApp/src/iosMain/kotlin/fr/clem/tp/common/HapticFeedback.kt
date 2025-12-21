package fr.clem.tp.common

actual class HapticFeedback {
    actual fun vibrateLight() {
        val generator = UINotificationFeedbackGenerator()
        generator.notificationOccurred(UINotificationFeedbackTypeWarning)
    }
}