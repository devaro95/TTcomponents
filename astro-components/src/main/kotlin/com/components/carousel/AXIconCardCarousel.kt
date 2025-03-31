package com.components.carousel

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.carousel.model.AXIconCarouselItemData
import com.components.text.*
import com.theming.AXTheme
import com.theming.colors.AXCardColors
import com.vro.compose.preview.VROLightMultiDevicePreview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

/**
 * `AXIconCardCarousel` is a composable function that displays a horizontal carousel of icon cards.
 *
 * This component presents a scrollable row of cards, each containing an icon and associated text.
 * It supports an optional title and description above the carousel and allows customization of
 * card colors.
 *
 * @param modifier Modifier to apply to the overall container `Column`. Use this to control layout
 *                 properties such as padding and positioning.
 * @param items An `ImmutableList` of `AXIconCarouselItemData` objects, each representing a
 *              single card in the carousel.  Each item contains the icon resource ID and the
 *              text to display.
 * @param title Optional title text to display above the carousel.
 * @param description Optional description text to display below the title (if present) and above
 *                    the carousel.
 * @param colors Custom colors to use for the card backgrounds. Defaults to
 *               `AXTheme.colorScheme.cardColors`.
 * @param onItemClick Lambda that is invoked when a card in the carousel is clicked.
 *
 * Example Usage:
 * @sample AXIconCardCarouselPreview
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AXIconCardCarousel(
    modifier: Modifier = Modifier,
    items: ImmutableList<AXIconCarouselItemData>,
    title: String? = null,
    description: String? = null,
    colors: AXCardColors = AXTheme.colorScheme.cardColors,
    onItemClick: () -> Unit,
) {
    Column(modifier = modifier) {
        title?.let {
            AXHeaderText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

        }
        description?.let {
            AXTitleText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyRow(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    ElevatedCard(
                        modifier = Modifier
                            .width(90.dp)
                            .height(90.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = colors.containerColor
                        ),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 6.dp
                        )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() },
                                    onClick = { onItemClick() },
                                )
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = it.icon),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            AXBodyText(
                                text = it.text,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun AXIconCardCarouselPreview() {
    Column {
        val items = persistentListOf(
            AXIconCarouselItemData(text = "Food", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Museums", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Routes", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Countries", icon = R.drawable.ic_hamb)
        )

        AXIconCardCarousel(
            items = items,
            onItemClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        AXIconCardCarousel(
            items = items,
            title = "Explore Categories",
            onItemClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        AXIconCardCarousel(
            items = items,
            title = "Featured",
            description = "Discover our curated collections",
            onItemClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}