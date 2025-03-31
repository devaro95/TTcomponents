package com.components.carousel

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
import com.axcomponents.app.R
import com.components.carousel.model.AXIconCarouselItemData
import com.components.text.*
import com.theming.AXTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet

/**
 * `AXIconCarousel` is a composable function that displays a horizontal carousel of circular icons
 * with accompanying text.
 *
 * This component presents a scrollable row of items, each consisting of a circular icon with text
 * displayed below it. It supports an optional title and description above the carousel.
 *
 * @param modifier Modifier to apply to the overall container `Column`. Use this to control layout
 *                 properties such as padding and positioning.
 * @param items A `List` of `AXIconCarouselItemData` objects, each representing a single item in
 *              the carousel. Each item contains the icon resource ID and the text to display.
 * @param title Optional title text to display above the carousel.
 * @param description Optional description text to display below the title (if present) and above
 *                    the carousel.
 * @param onItemClick Lambda that is invoked when an item (icon or text) in the carousel is
 *                    clicked.
 *
 * Example Usage:
 * @sample AXIconCarouselPreview
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AXIconCarousel(
    modifier: Modifier = Modifier,
    items: ImmutableList<AXIconCarouselItemData>,
    title: String? = null,
    description: String? = null,
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
                                    border = BorderStroke(1.5.dp, AXTheme.colorScheme.primaryColor),
                                    shape = RoundedCornerShape(100.dp)
                                )
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

@VROLightMultiDevicePreview
@Composable
private fun AXIconCarouselPreview() {
    Column {
        val items = listOf(
            AXIconCarouselItemData(text = "Food", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Museums", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Routes", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Countries", icon = R.drawable.ic_hamb)
        ).toImmutableList()

        AXIconCarousel(
            items = items,
            onItemClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AXIconCarousel(
            items = items,
            title = "Explore",
            onItemClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AXIconCarousel(
            items = items,
            title = "Categories",
            description = "Browse our popular categories",
            onItemClick = { }
        )
    }
}