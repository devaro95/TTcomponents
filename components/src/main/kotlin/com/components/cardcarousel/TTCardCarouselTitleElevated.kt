package com.components.cardcarousel

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.components.cardcarousel.model.TTCardCarouselTitleItem
import com.components.styles.CardBackground
import com.components.text.*
import com.mock.textLongMock
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardCarouselTitleNew` is a composable function that creates a horizontal carousel of cards,
 * each with an image and a title, along with an optional title and description for the carousel itself.
 *
 * This component is designed to display a scrollable list of cards. It can also display an
 * optional title and description above the carousel.
 *
 * This component is similar to `TTCardCarouselTitle` but uses a different implementation of the cards:
 * `TTCardCarouselTitleElevatedItem`.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the carousel.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param title An optional title string to display above the carousel. Displayed using `AXHeaderText16`.
 * @param description An optional description string to display below the title. Displayed using `AXTitleText16`.
 * @param items A list of `TTCardCarouselTitleItem` objects, each representing a card in the carousel.
 * @param onCardClick Lambda that is invoked when a card is clicked. It provides the `id` of the clicked card.
 *
 * Example Usage:
 * @sample TTCardCarouselTitleElevatedPreview
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardCarouselTitleElevated(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    items: List<TTCardCarouselTitleItem>,
    onCardClick: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        title?.let {
            AXHeaderText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp)
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
                modifier = Modifier.padding(top = if (title.isNullOrEmpty() && description.isNullOrEmpty()) 0.dp else 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    TTCardCarouselTitleElevatedItem(it, onCardClick)
                }
            }
        }
    }
}

/**
 * `TTCardCarouselTitleElevatedItem` is a composable function that creates an individual card item for use within
 * a `TTCardCarouselTitleElevated` carousel.
 *
 * This component displays an image and a text title within an elevated card layout. It's designed to be
 * used as an individual item within a horizontal carousel.
 *
 * @param item The `TTCardCarouselTitleItem` object containing the data for this card (image and title).
 * @param onCardClick Lambda that is invoked when the card is clicked. It provides the `id` of the clicked card.
 *
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun TTCardCarouselTitleElevatedItem(
    item: TTCardCarouselTitleItem,
    onCardClick: (Int) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .width(260.dp)
            .height(250.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = CardBackground
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        ),
        onClick = { onCardClick.invoke(item.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(CardBackground)
        ) {
            AsyncImage(
                modifier = Modifier.height(200.dp),
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                AXHeaderText18(
                    modifier = Modifier.padding(start = 16.dp),
                    text = item.title
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselTitleElevatedPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val itemList = listOf(
            TTCardCarouselTitleItem(id = 1, title = "Item 1", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 2, title = "Item 2", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 3, title = "Item 3", image = R.drawable.country)
        )
        TTCardCarouselTitleElevated(
            title = "Carousel with Title and Description",
            description = "This is a description of the carousel.",
            items = itemList,
            onCardClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitleElevated(
            title = "Carousel with Only Title",
            items = itemList,
            onCardClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitleElevated(
            description = "Carousel with Only Description",
            items = itemList,
            onCardClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitleElevated(
            items = itemList,
            onCardClick = { }
        )
        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselTitleElevated(
            title = "Carousel with long Description",
            description = textLongMock,
            items = itemList,
            onCardClick = { }
        )
    }
}
