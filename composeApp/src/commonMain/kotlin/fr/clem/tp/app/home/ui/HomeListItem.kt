package fr.clem.tp.app.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import fr.clem.tp.app.home.HomeItem
import fr.clem.tp.common.ui.toImageModel

@Composable
fun HomeListItem(
    item: HomeItem,
    onClick: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(item.id) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            imageModel = { item.image?.toImageModel() },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop
            ),
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}