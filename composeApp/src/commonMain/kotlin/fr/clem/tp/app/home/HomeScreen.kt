package fr.clem.tp.app.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil3.CoilImage
import fr.clem.tp.app.create.defaultCreateImages
import fr.clem.tp.app.home.ui.HomeListItem
import fr.clem.tp.navigation.Navigator
import fr.clem.tp.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()
    val navigator = koinInject<Navigator>()

    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeIntent.Init)

        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToDetails -> navigator.navigateTo(Screen.Details(effect.id))
                HomeEffect.NavigateToCreate -> navigator.navigateTo(Screen.Create)
                HomeEffect.NavigateToFavorites -> navigator.navigateTo(Screen.Favorites)
            }
        }
    }

    HomeComposable(
        state = state,
        onCreateClick = { viewModel.onIntent(HomeIntent.CreateElement) },
        onFavoritesClick = { viewModel.onIntent(HomeIntent.GoToFavorites) },
        onItemClick = { id -> viewModel.onIntent(HomeIntent.GoToDetails(id)) }
    )
}

@Composable
fun HomeComposable(
    state: HomeState,
    onCreateClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onItemClick: (String) -> Unit,
) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = onCreateClick,
                    icon = {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    label = {
                        Text(
                            "Créer",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onFavoritesClick,
                    icon = {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            tint = Color.Yellow
                        )
                    },
                    label = {
                        Text(
                            "Favoris",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
            }
        }
    ) { padding ->
        HomeContent(
            items = state.items,
            onItemClick = onItemClick,
        )
    }
}

@Composable
fun HomeContent(
    items: List<HomeItem>,
    onItemClick: (String) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {

        CoilImage(
            imageModel = { "https://static.wikia.nocookie.net/jamescameronsavatar/images/b/b4/Avatar_New_Logo_%282016%29.png/revision/latest?cb=20210823190708" },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(items) { item ->
                HomeListItem(item) {
                    onItemClick(item.id)
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeComposable(
        state = HomeState(
            items = defaultCreateImages
        ),
        onCreateClick = {},
        onFavoritesClick = {},
        onItemClick = {}
    )
}