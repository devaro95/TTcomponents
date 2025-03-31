package com.components.menu

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
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.components.menu.model.AXMenuItemData
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableArrowData
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableData
import com.components.menu.model.AXMenuItemData.AXMenuItemSwitchData
import com.components.text.AXHeaderText14
import com.components.text.AXHeaderText16
import com.theming.AXTheme
import com.theming.colors.AXMenuColors
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `AXMenuItem` is a composable function that renders a single item within a menu.
 * It can display different types of menu items, such as clickable items,
 * clickable items with an arrow, or items with a switch.
 *
 * The appearance and behavior of the menu item are determined by the `AXMenuItemData`
 * object passed to it.
 *
 * @param modifier Modifier to apply to the outer `Row` containing the menu item.
 *                 Use this to control padding, alignment, and other layout properties.
 * @param data An instance of [AXMenuItemData], which describes the type,
 *             content, and behavior of the menu item. It can be one of the following:
 *             - `AXMenuItemClickableArrowData`: Represents a clickable item with an arrow indicator.
 *             - `AXMenuItemClickableData`: Represents a simple clickable item.
 *             - `AXMenuItemSwitchData`: Represents an item with a switch.
 *
 * Example usage:
 * @sample AXMenuItemPreview()
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun AXMenuItem(
    modifier: Modifier = Modifier,
    data: AXMenuItemData,
    colors: AXMenuColors = AXTheme.colorScheme.menuColors,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    when (data) {
                        is AXMenuItemClickableArrowData -> data.onClick()
                        is AXMenuItemClickableData -> data.onClick()
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
                AXIcon(
                    iconRes = data.icon,
                    size = data.iconSize
                )
            }

            when (data.textType) {
                AXMenuItemData.TextType.NORMAL -> AXHeaderText14(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor
                )

                AXMenuItemData.TextType.BIG -> AXHeaderText16(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor,
                )
            }
            when (data) {
                is AXMenuItemSwitchData ->
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                        Switch(
                            modifier = Modifier
                                .padding(0.dp),
                            checked = data.isChecked,
                            onCheckedChange = data.onChange,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = colors.checkedThumbColor,
                                checkedTrackColor = colors.checkedTrackColor,
                                uncheckedThumbColor = colors.uncheckedThumbColor,
                                uncheckedTrackColor = colors.uncheckedTrackColor
                            )
                        )
                    }

                is AXMenuItemClickableArrowData -> AXIcon(
                    modifier = Modifier.rotate(180f),
                    iconRes = R.drawable.ic_back,
                )

                is AXMenuItemClickableData -> Unit
            }
        }
    }
}


@VROLightMultiDevicePreview
@Composable
private fun AXMenuItemPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        AXMenuItem(
            data = AXMenuItemClickableArrowData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                onClick = {}
            )
        )
        AXMenuItem(
            data = AXMenuItemClickableArrowData(
                icon = R.drawable.ic_edit,
                text = "Example",
                onClick = {},
                iconSize = 20.dp,
                textType = AXMenuItemData.TextType.NORMAL
            )
        )
        AXMenuItem(
            data = AXMenuItemSwitchData(
                icon = R.drawable.ic_diamond,
                text = "Example",
                isChecked = false,
                onChange = {},
            )
        )
    }
}