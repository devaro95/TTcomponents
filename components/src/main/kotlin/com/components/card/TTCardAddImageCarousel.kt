package com.components.card

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.domain.model.GuideModel.ImageModel
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardAddImageCarousel` is a composable function that creates a horizontally scrollable carousel of `TTCardAddImage` components.
 *
 * It displays a list of images, allowing the user to scroll through them horizontally. Each image in the carousel is
 * represented by a `TTCardAddImage` component, and clicking on an image triggers an `onClick` event.
 *
 * @param modifier Modifier to apply to the outer `LazyRow` containing the carousel.
 *                 Use this to control layout properties, such as padding and size.
 * @param imageList A list of `ImageModel` objects, each representing an image to be displayed in the carousel.
 * @param type The `TTCardAddImageCarouselType` which determines the width of each `TTCardAddImage` in the carousel.
 *             It can be either `SMALL` or `BIG`.
 * @param onClick Lambda that is invoked when an image is clicked. It provides the index of the clicked image in the `imageList`.
 *
 *
 * Example Usage:
 * @sample TTCardAddImageCarouselPreview
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardAddImageCarousel(
    modifier: Modifier = Modifier,
    imageList: List<ImageModel>,
    type: TTCardAddImageCarouselType,
    onClick: (Int) -> Unit,
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(imageList) { index, item ->
                TTCardAddImage(
                    modifier = Modifier
                        .width(type.width.dp)
                        .height(180.dp),
                    image = item,
                    onClick = { onClick.invoke(index) }
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardAddImageCarouselPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTCardAddImageCarousel(
            imageList = listOf(
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+1"),
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+2"),
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+3")
            ),
            type = TTCardAddImageCarouselType.BIG,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTCardAddImageCarousel(
            imageList = listOf(
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+4"),
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+5"),
                ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+6"),
                ImageModel()
            ),
            type = TTCardAddImageCarouselType.SMALL,
            onClick = {}
        )
    }
}