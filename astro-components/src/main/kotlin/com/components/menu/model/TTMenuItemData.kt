package com.components.menu.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class AXMenuItemData(
    @DrawableRes open val icon: Int,
    open val iconSize: Dp,
    open val text: String,
    open val textColor: Color,
    open val textType: TextType,
) {
    data class AXMenuItemSwitchData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val isChecked: Boolean,
        val onChange: ((Boolean) -> Unit),
    ) : AXMenuItemData(icon, iconSize, text, textColor, textType)

    data class AXMenuItemClickableArrowData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : AXMenuItemData(icon, iconSize, text, textColor, textType)

    data class AXMenuItemClickableData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : AXMenuItemData(icon, iconSize, text, textColor, textType)

    enum class TextType {
        NORMAL, BIG
    }
}