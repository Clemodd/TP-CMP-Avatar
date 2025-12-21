package fr.clem.tp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import fr.clem.tp.app.AppTheme
import fr.clem.tp.navigation.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    AppTheme {
        val entryProvider = koinEntryProvider()
        val navigator = koinInject<Navigator>()

        NavDisplay(
            backStack = navigator.backStack,
            onBack = { navigator.goBack() },
            entryProvider = entryProvider,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                // rememberViewModelStoreNavEntryDecorator() est non compatible KMP pour le moment
            )
        )
    }
}