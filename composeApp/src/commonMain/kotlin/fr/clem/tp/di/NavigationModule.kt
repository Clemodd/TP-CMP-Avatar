package fr.clem.tp.di

import fr.clem.tp.navigation.Navigator
import fr.clem.tp.navigation.Screen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module


@OptIn(KoinExperimentalAPI::class)
val navigationModule = module {
    single { Navigator(startDestination = Screen.Home) }

    // TODO TP2.1 : Navigation de HomeScreen
    // TODO TP2.3 : navigation<Screen.Details>, navigation<Screen.Create>, navigation<Screen.Favorites>
}

