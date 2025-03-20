package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.card.TTCardAddImageCarousel
import com.components.card.TTCardAddImageCarouselType
import com.domain.model.GuideModel
import com.mock.imageMock
import com.utils.Section

@Composable
fun TTCardAddImageCarouselSection() {
    Column {
        val imageList = listOf(
            GuideModel.ImageModel(imageUrl = imageMock),
            GuideModel.ImageModel(imageUrl = imageMock),
            GuideModel.ImageModel(imageUrl = imageMock)
        )
        Section(title = "TTCardAddImageCarousel Big") {
            TTCardAddImageCarousel(
                imageList = imageList,
                type = TTCardAddImageCarouselType.BIG,
                onClick = {}
            )
        }
        Section(title = "TTCardAddImageCarousel Small") {
            TTCardAddImageCarousel(
                imageList = imageList,
                type = TTCardAddImageCarouselType.SMALL,
                onClick = {}
            )
        }
    }
}