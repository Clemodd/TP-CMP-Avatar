package fr.clem.tp.app.favorite

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.clem.tp.common.ui.TopBar

@Composable
fun FavoriteScreen() {

    LaunchedEffect(Unit) {
    }

    FavoriteComposable(
        state = FavoriteState(),
        onBackClick = { /* TODO TP3 */ },
        onToggleFavorite = { _, _ -> /* TODO TP3 */ }
    )
}

@Composable
fun FavoriteComposable(
    state: FavoriteState,
    onBackClick: () -> Unit,
    onToggleFavorite: (String, Boolean) -> Unit,
) {
    Scaffold(
        topBar = { TopBar(onBackClick = onBackClick) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(state.items) { item ->
                FavoriteItem(
                    item = item,
                    onToggleFavorite = onToggleFavorite
                )
            }
        }
    }
}

@Composable
fun FavoriteItem(
    item: FavoriteItem,
    onToggleFavorite: (String, Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
    }
}
