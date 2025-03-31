package com.sections.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.axcomponents.app.R
import com.components.carousel.AXIconCardCarousel
import com.components.carousel.model.AXIconCarouselItemData
import com.sections.Section
import kotlinx.collections.immutable.toImmutableList

@Composable
fun AXIconCardCarouselSection() {
    Column {
        val items = listOf(
            AXIconCarouselItemData(text = "Option 1", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 2", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 3", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 4", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 5", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 6", icon = R.drawable.ic_hamb),
            AXIconCarouselItemData(text = "Option 7", icon = R.drawable.ic_hamb),
        ).toImmutableList()
        Section(title = "AXIconCardCarousel") {
            AXIconCardCarousel(
                items = items,
                title = "Categories",
                description = "Browse our popular categories",
                onItemClick = {}
            )
        }
        Section(title = "AXIconCardCarousel with no title") {
            AXIconCardCarousel(
                items = items,
                title = "Explore",
                onItemClick = {}
            )
        }
        Section(title = "AXIconCardCarousel with no title or description") {
            AXIconCardCarousel(
                items = items,
                onItemClick = {}
            )
        }
    }
}