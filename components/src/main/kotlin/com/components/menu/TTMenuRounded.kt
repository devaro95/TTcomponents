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
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.components.styles.InputBorder
import com.components.styles.SecondaryBackground
import com.components.text.TTHeaderText14
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

/**
 * `TTMenuRounded` is a composable function that creates a rounded menu layout with an optional title.
 * It displays a list of `TTMenuItem` components within a rounded container, providing a visually distinct
 * section within the application.
 *
 * This component is useful for grouping related menu items in a clear and aesthetically pleasing way.
 *
 * @param modifier Modifier to apply to the outer `Column` that wraps the entire rounded menu.
 *                 Use this to control padding, alignment, and other layout properties of the menu.
 * @param title The title text to display above the menu items. Defaults to an empty string.
 *              This is displayed using the `TTHeaderText14` composable.
 * @param items A list of `TTMenuItemData` objects, each representing a single menu item to be displayed.
 *              The type of menu item (e.g., clickable, switch) is determined by the specific
 *              implementation of `TTMenuItemData`.
 *
 * Example Usage:
 * @sample TTMenuRoundedPreview
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TTMenuRounded(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTMenuItemData>,
) {
    Column(modifier) {
        TTHeaderText14(
            modifier = Modifier.padding(start = 8.dp),
            text = title
        )
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .border(1.dp, InputBorder, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(SecondaryBackground)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items.forEach {
                TTMenuItem(data = it)
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuRoundedPreview() {
    TTMenuRounded(
        title = "Title",
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