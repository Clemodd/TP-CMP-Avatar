package fr.clem.tp.app.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
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
import fr.clem.tp.common.ui.TopBar
import fr.clem.tp.common.ui.toImageModel
import fr.clem.tp.navigation.Navigator
import fr.clem.tp.navigation.Screen
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailScreen(
    id: String,
) {
    val viewModel = koinViewModel<DetailViewModel>()
    val state by viewModel.state.collectAsState()
    val navigator = koinInject<Navigator>()

    LaunchedEffect(id) {
        viewModel.onIntent(DetailIntent.Init(id))
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is DetailEffect.PopBack -> navigator.goBack()
            }
        }
    }

    DetailComposable(
        state = state,
        onBackClick = { viewModel.onIntent(DetailIntent.GoBackToHome) },
        onFavoriteClick = { viewModel.onIntent(DetailIntent.ToggleFavorite) }
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
        Box {
            CoilImage(
                imageModel = { state.image?.toImageModel() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(16.dp)),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop
                )
            )

            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Favori",
                    tint = if (state.isFavorite) Color.Yellow else Color.White
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = state.title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = state.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}

