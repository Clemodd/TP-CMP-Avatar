package fr.clem.tp.domain.usecase

import fr.clem.tp.domain.repository.CharacterRepository
import fr.clem.tp.common.spec.HapticFeedback

class FavoriteUseCase(
    private val repository: CharacterRepository,
    private val haptic: HapticFeedback
) {
    suspend fun getAllFavorites() = repository.getFavorites()

    suspend fun updateFavorite(id: String, isFavorite: Boolean) {
        repository.updateFavorite(id, isFavorite)
        haptic.vibrateLight()
    }
}
