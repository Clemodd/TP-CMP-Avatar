package fr.clem.tp.di

import fr.clem.tp.app.create.CreateViewModel
import fr.clem.tp.app.detail.DetailViewModel
import fr.clem.tp.app.favorite.FavoriteViewModel
import fr.clem.tp.app.home.HomeViewModel
import fr.clem.tp.data.datasource.local.CharacterLocalDataSource
import fr.clem.tp.data.datasource.remote.DescriptionRemoteDataSource
import fr.clem.tp.data.datasource.remote.api.DescriptionCharacterApi
import fr.clem.tp.data.network.provideHttpClient
import fr.clem.tp.data.repository.CharacterRepositoryImpl
import fr.clem.tp.domain.repository.CharacterRepository
import fr.clem.tp.domain.usecase.CharacterUseCase
import fr.clem.tp.domain.usecase.FavoriteUseCase
import io.ktor.client.HttpClient
import org.koin.dsl.module

val globalModule = module {
    factory  { HomeViewModel(get()) }
    factory  { DetailViewModel(get(), get()) }
    factory  { CreateViewModel(get()) }
    factory  { FavoriteViewModel(get()) }

    single { CharacterUseCase(get()) }
    single<CharacterRepository> { CharacterRepositoryImpl(get(),get()) }
    single { CharacterLocalDataSource(get()) }
    single { DescriptionRemoteDataSource(get()) }
    single { DescriptionCharacterApi(get()) }

    single { FavoriteUseCase(get(),get()) }

    single<HttpClient> { provideHttpClient() }
}