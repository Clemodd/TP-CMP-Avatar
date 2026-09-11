package fr.clem.tp.di

import fr.clem.tp.app.home.HomeViewModel
import org.koin.dsl.module

val globalModule = module {
    factory { HomeViewModel(get()) }

    // TODO TP2.2 : HttpClient, DescriptionCharacterApi, DescriptionRemoteDataSource
    // TODO TP2.2 : CharacterRepository, CharacterUseCase, CharacterLocalDataSource, FavoriteUseCase
    // TODO TP2.3 : DetailViewModel, CreateViewModel, FavoriteViewModel
}