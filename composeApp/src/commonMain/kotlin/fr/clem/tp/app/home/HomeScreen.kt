package fr.clem.tp.app.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    // TODO TP2.1 : récupérer HomeViewModel avec Koin
    LaunchedEffect(Unit) {
    }

    HomeComposable()
}

@Composable
fun HomeComposable(
    state: HomeState = HomeState(),
    onItemClick: (String) -> Unit = {},
    onCreateClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {},
) {
    Scaffold(
        bottomBar = {
            // TODO TP3
        }
    ) { padding ->
        HomeContent(
            modifier = Modifier.padding(padding),
            state = state,
            onItemClick = onItemClick,
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    state: HomeState = HomeState(),
    onItemClick: (String) -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {

        CoilImage(
            imageModel = { "https://static.wikia.nocookie.net/jamescameronsavatar/images/b/b4/Avatar_New_Logo_%282016%29.png/revision/latest?cb=20210823190708" },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // TODO TP3
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(state.items) { item ->
                // TODO TP3
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeComposable()
}