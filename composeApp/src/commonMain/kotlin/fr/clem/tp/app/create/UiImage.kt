package fr.clem.tp.app.create

sealed interface UiImage {
    data class Remote(val url: String) : UiImage
    data class Local(val path: String) : UiImage
    data class Camera(val path: String) : UiImage
}