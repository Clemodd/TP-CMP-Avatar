package fr.clem.tp.app.detail

import fr.clem.tp.app.create.UiImage

data class DetailState(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val image: UiImage? = null,
    val isFavorite: Boolean = false
)
