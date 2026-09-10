package fr.clem.tp.di

import fr.clem.tp.app.home.HomeViewModel
import org.koin.dsl.module

val globalModule = module {
    factory { HomeViewModel(get()) }

    // TODO TP2 : HttpClient, DescriptionCharacterApi, DescriptionRemoteDataSource
    // TODO TP2 : CharacterRepository, CharacterUseCase, FavoriteUseCase
    // TODO TP3 : CharacterLocalDataSource, ViewModels
}