package fr.clem.tp.app.favorite

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import fr.clem.tp.app.home.HomeItem
import fr.clem.tp.common.ui.TopBar
import fr.clem.tp.common.ui.toImageModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavoriteScreen(
    navigateToHome: () -> Unit,
) {
    val viewModel = koinViewModel<FavoriteViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(FavoriteIntent.Init)

        viewModel.effect.collect { effect ->
            when (effect) {
                FavoriteEffect.NavigateToHome -> navigateToHome()
            }
        }
    }

    FavoriteComposable(
        state = state,
        onBackClick = { viewModel.onIntent(FavoriteIntent.Retour) },
        onToggleFavorite = { id, isFavorite ->
            viewModel.onIntent(FavoriteIntent.ToggleFavorite(id, isFavorite))
        }
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

        CoilImage(
            imageModel = { item.image?.toImageModel() },
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp)),
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop
            )
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = item.title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )

        IconButton(
            onClick = {
                onToggleFavorite(item.id, !item.isFavorite)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Favori",
                tint = if (item.isFavorite) Color.Yellow else Color.Gray
            )
        }
    }
}
