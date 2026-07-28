package fr.clem.tp.di

import fr.clem.tp.navigation.Navigator
import fr.clem.tp.navigation.Screen
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module


@OptIn(KoinExperimentalAPI::class)
val navigationModule = module {
    single { Navigator(startDestination = Screen.Home) }

    // TODO TP3 : navigation<Screen.XXX> { ... }
}

