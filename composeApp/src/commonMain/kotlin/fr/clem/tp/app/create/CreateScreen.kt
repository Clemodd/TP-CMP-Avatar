package fr.clem.tp.app.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.clem.tp.app.create.ui.CreateBottomBar
import fr.clem.tp.app.home.HomeItem
import fr.clem.tp.common.ui.TopBar

@Composable
fun CreateScreen() {

    LaunchedEffect(Unit) {
    }

    CreateComposable()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateComposable(
    state: CreateState = CreateState(),
    onTitleChanged: (String) -> Unit = {},
    onDescriptionChanged: (String) -> Unit = {},
    onImageSelected: (UiImage) -> Unit = {},
    onValidateClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        topBar = { TopBar(onBackClick = onBackClick) },
        bottomBar = { CreateBottomBar(state = state, onValidateClick = onValidateClick) }
    ) { padding ->
        CreateContent(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            state = state,
            onTitleChanged = onTitleChanged,
            onDescriptionChanged = onDescriptionChanged,
            onImageSelected = onImageSelected,
        )
    }
}

@Composable
fun CreateContent(
    modifier: Modifier = Modifier,
    state: CreateState = CreateState(),
    onTitleChanged: (String) -> Unit = {},
    onDescriptionChanged: (String) -> Unit = {},
    onImageSelected: (UiImage) -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {

        Text("Ajouter un personnage", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(12.dp))

        // TODO TP3
        LazyRow {
            items(defaultCreateImages) { item ->
                // TODO TP3
            }
        }

        Spacer(Modifier.height(12.dp))

        // TODO TP3
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

