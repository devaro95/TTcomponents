package com.components.card

/**
 * `TTCardAddImageCarouselType` is an enum class that defines the different size options for the `TTCardAddImage`
 * components within a `TTCardAddImageCarousel`.
 *
 * It provides two predefined types: `SMALL` and `BIG`, each with an associated width.
 *
 * The width is used by the `TTCardAddImageCarousel` composable to determine the width of
 * each image card in the carousel.
 *
 * Enum Values:
 * - **SMALL:** Represents a smaller image card size, with a width of 180 density-independent pixels (dp).
 * - **BIG:** Represents a larger image card size, with a width of 300 density-independent pixels (dp).
 *
 * Properties:
 * - **width:** An integer value representing the width of the `TTCardAddImage` component in dp.
 *
 * Usage:
 * Use these enum values when creating a `TTCardAddImageCarousel` to specify the desired size for the image cards.
 */
enum class TTCardAddImageCarouselType(val width: Int) {
    SMALL(180), BIG(300)
}