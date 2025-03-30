package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.cardcarousel.TTCardCarouselTitle
import com.components.cardcarousel.model.TTCardCarouselTitleItem
import com.mock.textLongMock
import com.mock.titleMock
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTCardCarouselTitleSection() {
    Column {
        val itemList = listOf(
            TTCardCarouselTitleItem(id = 0, title = "Title", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 1, title = "Title", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 2, title = "Title", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 3, title = "Title", image = R.drawable.country)
        )
        Section(title = "TTCardCarouselTitle with title and description") {
            TTCardCarouselTitle(
                title = titleMock,
                description = textLongMock,
                items = itemList,
                onClick = { }
            )
        }
        Section(title = "TTCardCarouselTitle with title") {
            TTCardCarouselTitle(
                title = "Carousel with Only Title",
                items = itemList,
                onClick = { }
            )
        }
        Section(title = "TTCardCarouselTitle with description") {
            TTCardCarouselTitle(
                description = "Carousel with Only Description",
                items = itemList,
                onClick = { }
            )
        }
        Section(title = "TTCardCarouselTitle no title or description") {
            TTCardCarouselTitle(
                items = itemList,
                onClick = { }
            )
        }
    }
}
