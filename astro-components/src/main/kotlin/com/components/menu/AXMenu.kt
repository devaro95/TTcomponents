package com.components.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.menu.model.AXMenuItemData
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableArrowData
import com.components.menu.model.AXMenuItemData.AXMenuItemSwitchData
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `AXMenu` is a composable function that creates a vertical menu layout.
 * It displays a list of `AXMenuItem` components, each represented by a `AXMenuItemData` object.
 *
 * This component uses a `Column` to arrange the menu items vertically, with spacing in between them.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the menu items.
 *                 Use this to control padding, alignment, and other layout properties of the entire menu.
 * @param items A list of `AXMenuItemData` objects, each representing a single menu item to be displayed.
 *              The type of menu item (e.g., clickable, switch) is determined by the specific
 *              implementation of `AXMenuItemData`.
 *
 * Example Usage:
 * @sample AXMenuPreview
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AXMenu(
    modifier: Modifier = Modifier,
    items: List<AXMenuItemData>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items.forEach {
            AXMenuItem(data = it)
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun AXMenuPreview() {
    AXMenu(
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