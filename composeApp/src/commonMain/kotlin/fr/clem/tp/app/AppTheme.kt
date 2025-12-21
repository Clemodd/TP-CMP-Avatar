package fr.clem.tp.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = BlueBackground,
            surface = BlueBackground,
            primary = BlueBottomBar,
            onBackground = WhiteText,
            onSurface = WhiteText,
            onPrimary = WhiteText,

        ),
        content = content
    )
}

val BlueBackground = Color(0xFF000330)
val BlueBottomBar = Color(0xFF000314)
val WhiteText = Color.White