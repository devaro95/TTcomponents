package com.sections.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.axcomponents.app.R
import com.components.carousel.AXIconCarousel
import com.components.carousel.model.AXIconCarouselItemData
import com.sections.Section
import kotlinx.collections.immutable.toImmutableList

@Composable
fun AXIconCarouselSection() {
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
        Section(title = "AXIconCarousel") {
            AXIconCarousel(
                items = items,
                title = "Categories",
                description = "Browse our popular categories",
                onItemClick = {}
            )
        }
        Section(title = "AXIconCarousel with no title") {
            AXIconCarousel(
                items = items,
                title = "Explore",
                onItemClick = {}
            )
        }
        Section(title = "AXIconCarousel with no title or description") {
            AXIconCarousel(
                items = items,
                onItemClick = {}
            )
        }
    }
}