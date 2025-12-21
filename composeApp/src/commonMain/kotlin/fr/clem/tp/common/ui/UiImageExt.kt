package fr.clem.tp.common.ui

import fr.clem.tp.app.create.UiImage

fun UiImage.toImageModel(): String =
    when (this) {
        is UiImage.Remote -> url
        is UiImage.Local -> path
        is UiImage.Camera -> path
    }
