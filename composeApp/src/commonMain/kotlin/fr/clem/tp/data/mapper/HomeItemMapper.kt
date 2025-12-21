package fr.clem.tp.data.mapper

import fr.clem.tp.app.favorite.FavoriteItem
import fr.clem.tp.app.home.HomeItem
import fr.clem.tp.domain.model.Character

fun Character.toHomeItemUi(): HomeItem =
    HomeItem(
        id = this.id,
        title = this.title,
        image = this.image
    )

fun Character.toFavoriteItemUi(): FavoriteItem =
    FavoriteItem(
        id = this.id,
        title = this.title,
        image = this.image,
        isFavorite = this.isFavorite
    )