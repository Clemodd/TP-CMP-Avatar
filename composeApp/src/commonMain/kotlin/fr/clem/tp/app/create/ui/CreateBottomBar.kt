package fr.clem.tp.app.create.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.clem.tp.app.create.CreateState

@Composable
fun CreateBottomBar(
    state: CreateState,
    onValidateClick: () -> Unit,
) {
    Button(
        onClick = onValidateClick,
        enabled = state.isValid,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(bottom = 32.dp)
    ) {
        Text("Valider")
    }
}