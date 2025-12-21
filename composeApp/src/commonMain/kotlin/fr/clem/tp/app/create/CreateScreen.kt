package fr.clem.tp.app.create

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import fr.clem.tp.app.create.ui.CreateBottomBar
import fr.clem.tp.app.home.HomeItem
import fr.clem.tp.common.ui.TopBar
import fr.clem.tp.common.ui.toImageModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CreateScreen(
    navigateToHome: () -> Unit,
) {
    val viewModel = koinViewModel<CreateViewModel>()
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(CreateIntent.Init)

        viewModel.effect.collect { effect ->
            when (effect) {
                CreateEffect.NavigateToHome -> navigateToHome()
            }
        }
    }

    CreateComposable(
        state = state,
        images = defaultCreateImages,
        onBackClick = {
            scope.launch { viewModel.onIntent(CreateIntent.Back) }
        },
        onValidateClick = {
            scope.launch { viewModel.onIntent(CreateIntent.Validate) }
        },
        onTitleChange = {
            scope.launch { viewModel.onIntent(CreateIntent.TitleChanged(it)) }
        },
        onDescriptionChange = {
            scope.launch { viewModel.onIntent(CreateIntent.DescriptionChanged(it)) }
        },
        onImageSelected = {
            scope.launch { viewModel.onIntent(CreateIntent.ImageSelected(it.image!!)) }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateComposable(
    images: List<HomeItem>,
    state: CreateState,
    onBackClick: () -> Unit,
    onValidateClick: () -> Unit,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onImageSelected: (HomeItem) -> Unit,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { TopBar(onBackClick) },
        bottomBar = {
            CreateBottomBar(
                state = state,
                onValidateClick = onValidateClick
            )
        }
    ) { padding ->
        CreateContent(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            images = images,
            state = state,
            onImageSelected = onImageSelected,
            onTitleChange = onTitleChange,
            onDescriptionChange = onDescriptionChange
        )
    }
}

@Composable
fun CreateContent(
    modifier: Modifier = Modifier,
    images: List<HomeItem>,
    state: CreateState,
    onImageSelected: (HomeItem) -> Unit,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {

        Text("Ajouter un personnage", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(12.dp))

        LazyRow {
            items(images) { item ->
                Box(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = if (state.image == item.image) 2.dp else 0.dp,
                            color = if (state.image == item.image) Color.White else Color.Transparent,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onImageSelected(item) }
                ) {
                    CoilImage(
                        imageModel = { item.image?.toImageModel() },
                        modifier = Modifier.size(120.dp),
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop)
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = state.title,
            onValueChange = onTitleChange,
            label = { Text("Nom", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                cursorColor = Color.White,
            )
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = state.description,
            onValueChange = onDescriptionChange,
            label = { Text("Description", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                cursorColor = Color.White,
            ),
            minLines = 3
        )
    }
}

val defaultCreateImages = listOf(
    HomeItem(
        "1",
        "Neteyam",
        UiImage.Remote("https://static.wikia.nocookie.net/jamescameronsavatar/images/f/f2/Avatar_TWoW_Neteyam_Textless_Poster.jpg/revision/latest/scale-to-width-down/291?cb=20230117172254")
    ),
    HomeItem(
        "2",
        "Varang",
        UiImage.Remote("https://static.wikia.nocookie.net/jamescameronsavatar/images/9/9f/Avatar_Fire_and_Ash_Empire_Textless_Cover.jpg/revision/latest/scale-to-width-down/320?cb=20251021185611")
    ),
    HomeItem(
        "3",
        "Neytiri",
        UiImage.Remote("https://static.wikia.nocookie.net/jamescameronsavatar/images/e/e5/Avatar_TWoW_Neytiri_Textless_Poster.jpg/revision/latest/scale-to-width-down/320?cb=20221125232909")
    ),
    HomeItem(
        "4",
        "Loak",
        UiImage.Remote("https://static.wikia.nocookie.net/jamescameronsavatar/images/5/50/Avatar_TWoW_Lo%27ak_Textless_Poster.jpg/revision/latest/scale-to-width-down/320?cb=20221130005409")
    ),
    HomeItem(
        "5",
        "Jake",
        UiImage.Remote("https://static.wikia.nocookie.net/jamescameronsavatar/images/4/4b/Avatar_The_Way_of_Water_-_Jake_Textless.jpg/revision/latest/scale-to-width-down/320?cb=20221130005525")
    )
)

