package fr.clem.tp.app.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.clem.tp.common.ui.TopBar

@Composable
fun DetailScreen(
    id: String,
) {
    LaunchedEffect(id) {
    }

    LaunchedEffect(Unit) {
        // TODO TP3
    }

    DetailComposable(
        state = DetailState(),
        onBackClick = { /* TODO TP3 */ },
        onFavoriteClick = { /* TODO TP3 */ }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailComposable(
    state: DetailState,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    Scaffold(
        topBar = { TopBar(onBackClick = onBackClick) }
    ) { padding ->
        DetailContent(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            state = state,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    state: DetailState,
    onFavoriteClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

    }
}

