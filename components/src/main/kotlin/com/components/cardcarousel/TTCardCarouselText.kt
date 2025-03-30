package com.components.cardcarousel

import androidx.compose.foundation.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.text.TTBodyText
import com.domain.model.GuideModel.ImageModel
import com.extensions.toBitmap
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.mock.imageMock
import com.mock.textLongMock
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ONE
import dev.chrisbanes.snapper.ExperimentalSnapperApi

/**
 * `TTCardCarouselImage` is a composable function that creates a horizontal image carousel.
 *
 * This component displays a scrollable list of images, with an optional text label below the carousel.
 * It includes a pager indicator to show the current page and the total number of pages.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the carousel.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param itemModifier Modifier to apply to each individual `TTCardCarouselImageItem` in the carousel.
 *                     Use this to customize the layout of each image item.
 * @param items A list of `ImageModel` objects, each representing an image to be displayed in the carousel.
 * @param text An optional text string to display below the carousel. If empty, no text is shown.
 * @param height The desired height of each image item in the carousel.
 * @param border An optional `BorderStroke` to draw around each image item. If `null`, no border is drawn.
 * @param shape An optional `Shape` to use for clipping the image and border. Defaults to `RectangleShape`.
 * @param pageSpacing The spacing between each page in the carousel.
 *
 * Example Usage:
 * @sample TTCardCarouselImagePreview
 *
 */
@OptIn(ExperimentalSnapperApi::class)
@Composable
fun TTCardCarouselImage(
    modifier: Modifier = Modifier,
    itemModifier: Modifier = Modifier,
    items: List<ImageModel> = emptyList(),
    text: String = EMPTY_STRING,
    height: Dp = 240.dp,
    border: BorderStroke? = null,
    shape: Shape = RectangleShape,
    pageSpacing: Dp = 0.dp,
) {
    val state = rememberPagerState(pageCount = { items.size })
    Column {
        HorizontalPager(
            modifier = modifier.clip(shape),
            state = state,
            pageSpacing = pageSpacing,
            userScrollEnabled = items.size > INT_ONE
        ) {
            TTCardCarouselImageItem(
                modifier = itemModifier,
                item = items[it],
                height = height,
                border = border,
                shape = shape
            )
        }
        if (items.size > INT_ONE) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pageCount = items.size,
                    pagerState = state
                )
            }
        }
        if (text.isNotEmpty()) {
            TTBodyText(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp),
                text = text
            )
        }
    }
}

/**
 * `TTCardCarouselImageItem` is a composable function that creates an individual image item for use within
 * a `TTCardCarouselImage` carousel.
 *
 * This component displays a single image, either from a URL or a Base64 string, within a specified height.
 * It handles the display of the image and ensures proper scaling and layout.
 *
 * @param item The `ImageModel` object containing the image data, either a URL or a Base64 string.
 * @param height The desired height of the image item.
 * @param modifier Modifier to apply to the outer `Box` containing the image.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param border An optional `BorderStroke` to draw around the image item. If `null`, no border is drawn.
 * @param shape An optional `Shape` to use for clipping the image and border. Defaults to `RectangleShape`.
 *
 */
@Composable
private fun PagerScope.TTCardCarouselImageItem(
    modifier: Modifier,
    item: ImageModel,
    height: Dp,
    border: BorderStroke?,
    shape: Shape,
) {
    Box(
        modifier = modifier
            .then(border?.let {
                Modifier.border(border, shape)
            } ?: Modifier
            )
            .clip(shape)
            .fillMaxWidth()
            .height(height),
    ) {
        if (item.imageUrl.isEmpty()) {
            Image(
                bitmap = item.imageBase64.toBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = item.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
fun TTCardCarouselImagePreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTCardCarouselImage(
            items = listOf(
                ImageModel(imageUrl = imageMock),
                ImageModel(imageUrl = imageMock),
                ImageModel(imageUrl = imageMock)
            ),
            text = "Carousel with Multiple Images and Text",
            height = 200.dp,
            pageSpacing = 8.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselImage(
            items = listOf(
                ImageModel(imageUrl = imageMock)
            ),
            text = EMPTY_STRING,
            height = 150.dp,
            pageSpacing = 0.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselImage(
            items = listOf(
                ImageModel(imageUrl = imageMock),
                ImageModel(imageUrl = imageMock),
                ImageModel(imageUrl = imageMock),
                ImageModel(imageUrl = imageMock)
            ),
            text = textLongMock,
            height = 250.dp,
            pageSpacing = 16.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTCardCarouselImage(
            items = emptyList(),
            text = "",
            height = 100.dp,
            pageSpacing = 0.dp
        )
    }
}