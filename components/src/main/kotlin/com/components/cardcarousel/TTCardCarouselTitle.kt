package com.components.cardcarousel

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.components.cardcarousel.model.TTCardCarouselTitleItem
import com.components.text.*
import com.extensions.jumpOnSpace
import com.mock.textLongMock
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardCarouselTitle` is a composable function that creates a horizontal carousel of cards,
 * each with an image and a title, along with an optional title and description for the carousel itself.
 *
 * This component is designed to display a scrollable list of cards. It can also display an
 * optional title and description above the carousel.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the carousel.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param title An optional title string to display above the carousel. Displayed using `TTHeaderText16`.
 * @param description An optional description string to display below the title. Displayed using `TTTitleText16`.
 * @param items A list of `TTCardCarouselTitleItem` objects, each representing a card in the carousel.
 * @param onClick Lambda that is invoked when a card is clicked. It provides the `id` of the clicked card.
 *
 * Example Usage:
 * @sample TTCardCarouselTitlePreview
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardCarouselTitle(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    items: List<TTCardCarouselTitleItem>,
    onClick: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        title?.let {
            TTHeaderText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp)
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
                modifier = Modifier.padding(top = if (title.isNullOrEmpty() && description.isNullOrEmpty()) 0.dp else 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    TTCardCarouselTitleItem(it, onClick)
                }
            }
        }
    }
}

/**
 * `TTCardCarouselTitleItem` is a composable function that creates a single card item for use within a
 * `TTCardCarouselTitle` carousel.
 *
 * This component displays an image and a text title within a card layout. It's designed to be used
 * as an individual item within a horizontal carousel.
 *
 * @param item The `TTCardCarouselTitleItem` object containing the data for this card (image and title).
 * @param onClick Lambda that is invoked when the card is clicked. It provides the `id` of the clicked card.
 *
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun TTCardCarouselTitleItem(
    item: TTCardCarouselTitleItem,
    onClick: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick.invoke(item.id) },
            )
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = item.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        TTHeaderTextVariant(
            text = item.title.jumpOnSpace(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp),
            fontSize = 20.sp
        )
    }
}


@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselTitlePreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTCardCarouselTitle(
            title = "Carousel with Title and Description",
            description = "This is a description of the carousel.",
            items = listOf(
                TTCardCarouselTitleItem(id = 1, title = "Item 1", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 2, title = "Item 2", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 3, title = "Item 3", image = R.drawable.country)
            ),
            onClick = { itemId -> println("Clicked on item: $itemId") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitle(
            title = "Carousel with Only Title",
            items = listOf(
                TTCardCarouselTitleItem(id = 4, title = "Item 4", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 5, title = "Item 5", image = R.drawable.country)
            ),
            onClick = { itemId -> println("Clicked on item: $itemId") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitle(
            description = "Carousel with Only Description",
            items = listOf(
                TTCardCarouselTitleItem(id = 6, title = "Item 6", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 7, title = "Item 7", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 8, title = "Item 8", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 9, title = "Item 9", image = R.drawable.country)
            ),
            onClick = { itemId -> println("Clicked on item: $itemId") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitle(
            items = listOf(
                TTCardCarouselTitleItem(id = 10, title = "Item 10", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 11, title = "Item 11", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 12, title = "Item 12", image = R.drawable.country)
            ),
            onClick = { itemId -> println("Clicked on item: $itemId") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitle(
            title = "Carousel with long Description",
            description = textLongMock,
            items = listOf(
                TTCardCarouselTitleItem(id = 13, title = "Item 13", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 14, title = "Item 14", image = R.drawable.country),
                TTCardCarouselTitleItem(id = 15, title = "Item 15", image = R.drawable.country)
            ),
            onClick = { itemId -> println("Clicked on item: $itemId") }
        )
    }
}