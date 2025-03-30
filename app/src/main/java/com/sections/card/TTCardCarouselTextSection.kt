package com.sections.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.cardcarousel.TTCardCarouselImage
import com.domain.model.GuideModel.ImageModel
import com.mock.imageMock
import com.mock.textLongMock
import com.theming.TTTheme
import com.sections.Section

@Composable
fun TTCardCarouselTextSection() {
    Spacer(modifier = Modifier.height(16.dp))
    Column {
        Section(title = "TTCardCarouselImage multi image") {
            TTCardCarouselImage(
                items = listOf(
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock)
                ),
                text = textLongMock,
                pageSpacing = 8.dp
            )
        }
        Section(title = "TTCardCarouselImage Single image") {
            TTCardCarouselImage(
                items = listOf(
                    ImageModel(imageUrl = imageMock)
                ),
                text = textLongMock,
                pageSpacing = 0.dp
            )
        }
        Section(title = "TTCardSelector different height") {
            TTCardCarouselImage(
                items = listOf(
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock)
                ),
                text = textLongMock,
                height = 200.dp,
                pageSpacing = 16.dp
            )
        }
        Section(title = "TTCardSelector different border") {
            TTCardCarouselImage(
                items = listOf(
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock)
                ),
                text = textLongMock,
                height = 200.dp,
                pageSpacing = 16.dp,
                border = BorderStroke(1.dp, TTTheme.colorScheme.primaryColor)
            )
        }
        Section(title = "TTCardSelector different border and shape") {
            TTCardCarouselImage(
                items = listOf(
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock),
                    ImageModel(imageUrl = imageMock)
                ),
                text = textLongMock,
                height = 200.dp,
                pageSpacing = 16.dp,
                border = BorderStroke(1.dp, TTTheme.colorScheme.primaryColor),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}
