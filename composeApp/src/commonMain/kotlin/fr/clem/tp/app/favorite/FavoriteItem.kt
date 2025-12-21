package fr.clem.tp.app.favorite

import fr.clem.tp.app.create.UiImage

data class FavoriteItem(
    val id: String,
    val title: String,
    val image: UiImage?,
    val isFavorite: Boolean
)