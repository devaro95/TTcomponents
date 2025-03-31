package com.components.input.model

/**
 * Enumeration that defines the types of input allowed in the `TTInput` component.
 *
 * This enum is used to specify whether the input field should only accept digits or allow a full range of characters.
 *
 * - **DIGITS:** Indicates that the input field should only accept digits (0-9).
 * - **FULL:** Indicates that the input field should accept any characters.
 *
 * This enum is typically used to control the behavior of the `TTInput` composable.
 *
 *
 **/
enum class AXInputType {
    DIGITS, FULL
}