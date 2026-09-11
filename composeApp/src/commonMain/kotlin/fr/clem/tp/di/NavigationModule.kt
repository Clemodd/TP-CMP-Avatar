package fr.clem.tp.di

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

    // TODO TP2.3 : navigation<Screen.Details>, navigation<Screen.Create>, navigation<Screen.Favorites>
}

