package com.components.menu

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemClickableData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.components.styles.White
import com.components.text.TTHeaderText14
import com.components.text.TTHeaderText16
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTMenuItem` is a composable function that renders a single item within a menu.
 * It can display different types of menu items, such as clickable items,
 * clickable items with an arrow, or items with a switch.
 *
 * The appearance and behavior of the menu item are determined by the `TTMenuItemData`
 * object passed to it.
 *
 * @param modifier Modifier to apply to the outer `Row` containing the menu item.
 *                 Use this to control padding, alignment, and other layout properties.
 * @param data An instance of [TTMenuItemData], which describes the type,
 *             content, and behavior of the menu item. It can be one of the following:
 *             - `TTMenuItemClickableArrowData`: Represents a clickable item with an arrow indicator.
 *             - `TTMenuItemClickableData`: Represents a simple clickable item.
 *             - `TTMenuItemSwitchData`: Represents an item with a switch.
 *
 * Example usage:
 * @sample TTMenuItemPreview()
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun TTMenuItem(
    modifier: Modifier = Modifier,
    data: TTMenuItemData,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    when (data) {
                        is TTMenuItemClickableArrowData -> data.onClick()
                        is TTMenuItemClickableData -> data.onClick()
                        else -> Unit
                    }
                },
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {
                TTIcon(
                    iconRes = data.icon,
                    size = data.iconSize
                )
            }

            when (data.textType) {
                TTMenuItemData.TextType.NORMAL -> TTHeaderText14(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor
                )

                TTMenuItemData.TextType.BIG -> TTHeaderText16(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor,
                )
            }
            when (data) {
                is TTMenuItemSwitchData ->
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                        Switch(
                            modifier = Modifier
                                .padding(0.dp),
                            checked = data.isChecked,
                            onCheckedChange = data.onChange,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = TTTheme.colorScheme.secondaryColor,
                                checkedTrackColor = TTTheme.colorScheme.secondaryColor,
                                uncheckedThumbColor = White,
                                uncheckedTrackColor = TTTheme.colorScheme.secondaryColor
                            )
                        )
                    }

                is TTMenuItemClickableArrowData -> TTIcon(
                    modifier = Modifier.rotate(180f),
                    iconRes = R.drawable.ic_back,
                )

                is TTMenuItemClickableData -> Unit
            }
        }
    }
}

sealed class TTMenuItemData(
    @DrawableRes open val icon: Int,
    open val iconSize: Dp,
    open val text: String,
    open val textColor: Color,
    open val textType: TextType,
) {
    data class TTMenuItemSwitchData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val isChecked: Boolean,
        val onChange: ((Boolean) -> Unit),
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    data class TTMenuItemClickableArrowData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    data class TTMenuItemClickableData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Color.Unspecified,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    enum class TextType {
        NORMAL, BIG
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuItemPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TTMenuItem(
            data = TTMenuItemClickableArrowData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                onClick = {}
            )
        )
        TTMenuItem(
            data = TTMenuItemClickableArrowData(
                icon = R.drawable.ic_edit,
                text = "Example",
                onClick = {},
                iconSize = 20.dp,
                textType = TTMenuItemData.TextType.NORMAL
            )
        )
        TTMenuItem(
            data = TTMenuItemSwitchData(
                icon = R.drawable.ic_diamond,
                text = "Example",
                isChecked = false,
                onChange = {},
            )
        )
    }
}