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

    navigation<Screen.Home> {
        HomeScreen(
            navigateToDetails = { number ->
                get<Navigator>().navigateTo(destination = Screen.Details(id = number))
            },
            createElement = {
                get<Navigator>().navigateTo(destination = Screen.Create)
            },
            navigateToFavorites = {
                get<Navigator>().navigateTo(destination = Screen.Favorites)
            },
        )
    }

    navigation<Screen.Details> { screen ->
        DetailScreen(
            id = screen.id,
            goBackToHome = {
                get<Navigator>().replaceAll(destination = Screen.Home)
            }
        )
    }

    navigation<Screen.Create> { screen ->
        CreateScreen(
            navigateToHome = {
                get<Navigator>().replaceAll(destination = Screen.Home)
            }
        )
    }

    navigation<Screen.Favorites> { screen ->
        FavoriteScreen(
            navigateToHome = {
                get<Navigator>().replaceAll(destination = Screen.Home)
            }
        )
    }
}