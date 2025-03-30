package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.cardcarousel.TTCardCarouselTitleElevated
import com.components.cardcarousel.model.TTCardCarouselTitleItem
import com.mock.textLongMock
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTCardCarouselTitleElevatedSection() {
    Column {
        val itemList = listOf(
            TTCardCarouselTitleItem(id = 1, title = "Item 1", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 2, title = "Item 2", image = R.drawable.country),
            TTCardCarouselTitleItem(id = 3, title = "Item 3", image = R.drawable.country)
        )
        Section(title = "TTCardCarouselTitleElevated with title and description") {
            TTCardCarouselTitleElevated(
                title = "Carousel with long Description",
                description = textLongMock,
                items = itemList,
                onCardClick = { }
            )
        }
        Section(title = "TTCardCarouselTitleElevated with title") {
            TTCardCarouselTitleElevated(
                title = "Carousel with Only Title",
                items = itemList,
                onCardClick = { }
            )
        }
        Section(title = "TTCardCarouselTitleElevated with description") {
            TTCardCarouselTitleElevated(
                description = "Carousel with Only Description",
                items = itemList,
                onCardClick = { }
            )
        }
        Section(title = "TTCardCarouselTitleElevated no title or description") {
            TTCardCarouselTitleElevated(
                items = itemList,
                onCardClick = { }
            )
        }
    }
}
