package fr.clem.tp.di

import fr.clem.tp.app.create.CreateScreen
import fr.clem.tp.app.detail.DetailScreen
import fr.clem.tp.app.favorite.FavoriteScreen
import fr.clem.tp.app.home.HomeScreen
import fr.clem.tp.navigation.Navigator
import fr.clem.tp.navigation.Screen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation


@OptIn(KoinExperimentalAPI::class)
val navigationModule = module {
    single { Navigator(startDestination = Screen.Home) }

    navigation<Screen.Home> { HomeScreen() }
    navigation<Screen.Details> { screen -> DetailScreen(id = screen.id) }
    navigation<Screen.Create> { CreateScreen() }
    navigation<Screen.Favorites> { FavoriteScreen() }
}