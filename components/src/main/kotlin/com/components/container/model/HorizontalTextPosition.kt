package com.components.container.model

/**
 * `HorizontalTextPosition` is an enum class that defines the horizontal position of text
 * relative to an associated element, such as an icon or another visual component.
 *
 * It has two possible values:
 * - `Left`: Indicates that the text should be positioned to the left of the associated element.
 * - `Right`: Indicates that the text should be positioned to the right of the associated element.
 *
 * This enum is used to provide a consistent way to specify text placement within composables,
 * allowing for easy switching between left-aligned and right-aligned text.
 */
enum class HorizontalTextPosition {
    Left, Right
}