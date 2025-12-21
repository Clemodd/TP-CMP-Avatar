package fr.clem.tp.common.spec

actual class CameraManager {
    actual suspend fun takePhoto(): String? {
        // UIImagePickerController
        // Sauvegarde dans Documents/
        // Retourne path
        return null
    }
}
