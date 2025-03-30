package com.model

enum class ColorConfiguration(
    val title: String,
)

enum class Configuration(val title: String) {
    PRIMARY_COLOR("Primary Color"),
    SECONDARY_COLOR("Secondary Color"),
    BACKGROUND("Secondary Color"),
    INPUT_FOCUSED_BACKGROUND("Input focused background"),
    INPUT_UNFOCUSED_BACKGROUND("Input unfocused background"),
    INPUT_BORDER("Input Border"),
    BUTTON_BACKGROUND("Button Background"),
    BUTTON_TEXT("Button Text")
}