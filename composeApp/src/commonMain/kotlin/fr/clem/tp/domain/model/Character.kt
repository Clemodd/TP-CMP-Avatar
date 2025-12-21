package fr.clem.tp.domain.model

import fr.clem.tp.app.create.UiImage

data class Character(
    val id: String,
    val title: String,
    val description: String,
    val image: UiImage?,
    val isFavorite: Boolean
)