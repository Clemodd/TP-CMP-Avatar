package fr.clem.tp.data.mapper

import fr.clem.tp.CharacterEntity
import fr.clem.tp.app.create.CreateState
import fr.clem.tp.app.create.UiImage
import fr.clem.tp.data.enum.ImageType
import fr.clem.tp.domain.model.Character

fun CharacterEntity.toUiImage(): UiImage =
    when (ImageType.valueOf(imageType)) {
        ImageType.REMOTE -> UiImage.Remote(imagePath)
        ImageType.LOCAL  -> UiImage.Local(imagePath)
        ImageType.CAMERA -> UiImage.Camera(imagePath)
    }

fun UiImage.toDb(): Pair<String, String> =
    when (this) {
        is UiImage.Remote -> ImageType.REMOTE.name to url
        is UiImage.Local  -> ImageType.LOCAL.name to path
        is UiImage.Camera -> ImageType.CAMERA.name to path
    }

fun CreateState.toDomain(): Character =
    Character(
        id = "",
        title = title,
        description = description,
        image = image,
        isFavorite = false
    )
