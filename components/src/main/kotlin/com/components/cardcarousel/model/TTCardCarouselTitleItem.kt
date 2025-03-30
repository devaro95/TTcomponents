package com.components.cardcarousel.model

import androidx.annotation.DrawableRes


/**
 * `TTCardCarouselTitleItem` is a data class that represents a single card item within a `TTCardCarouselTitle` carousel.
 *
 * It holds the data necessary to display a card, including an ID, a title, and an image resource.
 *
 * @param id A unique identifier for this card item.
 * @param title The text title to be displayed on the card.
 * @param image The drawable resource ID (`@DrawableRes`) for the image to be displayed on the card.
 *
 */
data class TTCardCarouselTitleItem(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
)