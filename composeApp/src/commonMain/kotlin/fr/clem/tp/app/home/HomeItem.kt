package fr.clem.tp.app.home

import fr.clem.tp.app.create.UiImage

data class HomeItem(
    val id: String,
    val title: String,
    val image: UiImage?
)