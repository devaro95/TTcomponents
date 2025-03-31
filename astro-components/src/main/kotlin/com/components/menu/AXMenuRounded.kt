package com.components.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.menu.model.AXMenuItemData
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableArrowData
import com.components.menu.model.AXMenuItemData.AXMenuItemSwitchData
import com.components.text.AXHeaderText14
import com.theming.AXTheme
import com.theming.colors.AXMenuColors
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

/**
 * `AXMenuRounded` is a composable function that creates a rounded menu layout with an optional title.
 * It displays a list of `AXMenuItem` components within a rounded container, providing a visually distinct
 * section within the application.
 *
 * This component is useful for grouping related menu items in a clear and aesthetically pleasing way.
 *
 * @param modifier Modifier to apply to the outer `Column` that wraps the entire rounded menu.
 *                 Use this to control padding, alignment, and other layout properties of the menu.
 * @param title The title text to display above the menu items. Defaults to an empty string.
 *              This is displayed using the `AXHeaderText14` composable.
 * @param items A list of `AXMenuItemData` objects, each representing a single menu item to be displayed.
 *              The type of menu item (e.g., clickable, switch) is determined by the specific
 *              implementation of `AXMenuItemData`.
 *
 * Example Usage:
 * @sample AXMenuRoundedPreview
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AXMenuRounded(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<AXMenuItemData>,
    colors: AXMenuColors = AXTheme.colorScheme.menuColors,
) {
    Column(modifier) {
        AXHeaderText14(
            modifier = Modifier.padding(start = 8.dp),
            text = title
        )
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .border(1.dp, colors.borderColor, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(colors.containerColor)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items.forEach {
                AXMenuItem(data = it)
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun AXMenuRoundedPreview() {
    AXMenuRounded(
        title = "Title",
        items = listOf(
            AXMenuItemClickableArrowData(
                icon = R.drawable.ic_guides,
                text = "Example",
                onClick = {}
            ),
            AXMenuItemClickableArrowData(
                icon = R.drawable.ic_like_empty,
                text = "Example",
                onClick = {}
            ),
            AXMenuItemSwitchData(
                icon = R.drawable.ic_diamond,
                text = "Example",
                isChecked = false,
                onChange = {},
            )
        )
    )
}