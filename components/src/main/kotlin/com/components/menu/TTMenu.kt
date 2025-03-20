package com.components.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTMenu` is a composable function that creates a vertical menu layout.
 * It displays a list of `TTMenuItem` components, each represented by a `TTMenuItemData` object.
 *
 * This component uses a `Column` to arrange the menu items vertically, with spacing in between them.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the menu items.
 *                 Use this to control padding, alignment, and other layout properties of the entire menu.
 * @param items A list of `TTMenuItemData` objects, each representing a single menu item to be displayed.
 *              The type of menu item (e.g., clickable, switch) is determined by the specific
 *              implementation of `TTMenuItemData`.
 *
 * The composable function internally uses `Column` from Compose to arrange the menu items.
 * The `TTMenuItem` composable is responsible for rendering each individual menu item based on
 * the data provided.
 *
 * Example Usage:
 * @sample TTMenuPreview
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TTMenu(
    modifier: Modifier = Modifier,
    items: List<TTMenuItemData>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items.forEach {
            TTMenuItem(data = it)
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuPreview() {
    TTMenu(
        items = listOf(
            TTMenuItemClickableArrowData(
                icon = R.drawable.ic_guides,
                text = "Example",
                onClick = {}
            ),
            TTMenuItemClickableArrowData(
                icon = R.drawable.ic_like_empty,
                text = "Example",
                onClick = {}
            ),
            TTMenuItemSwitchData(
                icon = R.drawable.ic_diamond,
                text = "Example",
                isChecked = false,
                onChange = {},
            )
        )
    )
}