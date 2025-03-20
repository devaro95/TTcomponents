package com.components.icon

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.components.text.*
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTIconCarousel(
    modifier: Modifier = Modifier,
    items: List<TTIconCarouselItemData>,
    title: String? = null,
    description: String? = null,
    onItemClick: () -> Unit,
) {
    Column(modifier = modifier) {
        title?.let {
            TTHeaderText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

        }
        description?.let {
            TTTitleText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyRow(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = { onItemClick() },
                        )
                    ) {
                        Image(
                            painter = painterResource(id = it.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(100.dp))
                                .size(50.dp)
                                .border(
                                    border = BorderStroke(1.5.dp, TTTheme.colorScheme.primaryColor),
                                    shape = RoundedCornerShape(100.dp)
                                )
                        )
                        TTBodyText(
                            text = it.text,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

data class TTIconCarouselItemData(
    val text: String,
    val icon: Int,
)

@VROLightMultiDevicePreview
@Composable
private fun TTIconCarouselPreview() {
    TTIconCarousel(
        items = listOf(
            TTIconCarouselItemData(
                text = "Comida",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Museos",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Rutas",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Paises",
                icon = R.drawable.ic_hamb
            )
        ),
        onItemClick = {}
    )
}