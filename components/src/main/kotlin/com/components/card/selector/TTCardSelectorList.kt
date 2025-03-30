package com.components.card.selector

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.components.card.selector.model.TTCardSelectorItem
import com.components.card.selector.model.TTCardSelectorOtherItem
import com.ttcomponents.app.R
import com.components.input.TTInput
import com.components.text.TTHeaderText18
import com.components.text.TTTitleText16
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import java.io.Serializable
import kotlin.collections.plus

/**
 * `TTCardSelectorList` is a composable function that creates a vertical list of `TTCardSelector`
 * components, with an optional header, subheader, and an additional input field.
 *
 * This component is designed to display a list of selectable items, where each item is represented
 * by a `TTCardSelector`. It supports both single and multi-selection. Additionally, it can include
 * an input field for cases where the user might need to provide a custom value not listed in the
 * selectable items.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the list.
 *                 Use this to control layout properties such as padding, size, and alignment.
 * @param header An optional header text to display above the list. Displayed using `TTHeaderText18`.
 * @param subHeader An optional subHeader text to display below the header.
 *                  If `null` and `multiSelection` is true, a default subHeader is used, indicating multiple selection.
 *                  Displayed using `TTTitleText16`.
 * @param items A list of `TTCardSelectorItem` objects, each representing a selectable item in the list.
 * @param selectedValues A list of `TTCardSelectorItem` objects representing the currently selected items.
 *                       Items in the `items` list that are also in this list will be shown as selected.
 * @param onClick Lambda that is invoked when a `TTCardSelector` is clicked.
 *                It provides the `TTCardSelectorItem` of the clicked card.
 * @param multiSelection A boolean indicating whether the list supports multi-selection (true) or
 *                       single-selection (false).
 * @param isVisible A boolean indicating whether the list should be visible or not.
 * @param otherItem A `TTCardSelectorOtherItem` object that allows adding a `TTInput` at the end of the list.
 *                  It provides a field for adding a value, a placeholder, and a boolean for visibility.
 *
 * Example Usage:
 * @sample TTCardSelectorListPreview
 */
@Composable
fun TTCardSelectorList(
    modifier: Modifier = Modifier,
    header: String?,
    subHeader: String? = stringResource(id = R.string.multiple_selection_subheader),
    items: List<TTCardSelectorItem>,
    selectedValues: List<TTCardSelectorItem?>,
    onClick: (TTCardSelectorItem) -> Unit,
    multiSelection: Boolean = false,
    isVisible: Boolean = true,
    otherItem: TTCardSelectorOtherItem = TTCardSelectorOtherItem(),
) {
    if (isVisible) {
        Column(modifier = modifier) {
            header?.let {
                TTHeaderText18(
                    modifier = Modifier.padding(top = 16.dp),
                    text = it
                )
            }
            subHeader?.let {
                TTTitleText16(
                    modifier = Modifier.padding(top = 8.dp),
                    text = it
                )
            }
            items.forEach {
                TTCardSelector(
                    modifier = Modifier.padding(top = 12.dp),
                    item = it,
                    selected = it in selectedValues,
                    onClick = { value -> onClick(value) },
                    multiSelection = multiSelection
                )
            }
            if (otherItem.isVisible) {
                TTInput(
                    modifier = Modifier.padding(top = 8.dp),
                    value = otherItem.value,
                    onChange = { otherItem.onChange(it) },
                    placeholder = otherItem.placeholder
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardSelectorListPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Example 1: Single Selection List with Header and No Subheader
        var selectedSingleItem by remember { mutableStateOf<TTCardSelectorItem?>(null) }
        TTCardSelectorList(
            header = "$titleMock (Single Selection)",
            subHeader = null,
            items = listOf(
                TTCardSelectorItem("Option 1", 1),
                TTCardSelectorItem("Option 2", 2),
                TTCardSelectorItem("Option 3", 3)
            ),
            selectedValues = listOf(selectedSingleItem),
            onClick = { selectedItem ->
                selectedSingleItem = if (selectedSingleItem == selectedItem) null else selectedItem
                println("Single Selection: ${selectedItem.text}")
            },
            multiSelection = false,
            isVisible = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example 2: Multi-Selection List with Header and Subheader
        var selectedMultiItems by remember { mutableStateOf<List<TTCardSelectorItem?>>(emptyList()) }
        TTCardSelectorList(
            header = "$titleMock (Multi-Selection)",
            subHeader = "Choose multiple options",
            items = listOf(
                TTCardSelectorItem("Option A", 1),
                TTCardSelectorItem("Option B", 2),
                TTCardSelectorItem("Option C", 3)
            ),
            selectedValues = selectedMultiItems,
            onClick = { selectedItem ->
                selectedMultiItems = if (selectedMultiItems.contains(selectedItem)) {
                    selectedMultiItems.filter { it != selectedItem }
                } else {
                    selectedMultiItems + selectedItem
                }
                println("Multi-Selection: ${selectedItem.text}")
            },
            multiSelection = true,
            isVisible = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example 3: Multi-Selection List without Header and otherItem
        var selectedMultiItems2 by remember { mutableStateOf<List<TTCardSelectorItem?>>(emptyList()) }
        var otherValue by remember { mutableStateOf("") }
        TTCardSelectorList(
            header = null,
            subHeader = null,
            items = listOf(
                TTCardSelectorItem("Option D", 4),
                TTCardSelectorItem("Option E", 5),
                TTCardSelectorItem("Option F", 6)
            ),
            selectedValues = selectedMultiItems2,
            onClick = { selectedItem ->
                selectedMultiItems2 = if (selectedMultiItems2.contains(selectedItem)) {
                    selectedMultiItems2.filter { it != selectedItem }
                } else {
                    selectedMultiItems2 + selectedItem
                }
                println("Multi-Selection: ${selectedItem.text}")
            },
            multiSelection = true,
            isVisible = true,
            otherItem = TTCardSelectorOtherItem(
                isVisible = true,
                placeholder = "Other value",
                value = otherValue,
                onChange = {newValue ->
                    otherValue = newValue
                    println("otherValue: $otherValue")
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example 4: not visible list
        var selectedSingleItem2 by remember { mutableStateOf<TTCardSelectorItem?>(null) }
        TTCardSelectorList(
            header = "$titleMock (Single Selection no visible)",
            subHeader = null,
            items = listOf(
                TTCardSelectorItem("Option 1", 1),
                TTCardSelectorItem("Option 2", 2),
                TTCardSelectorItem("Option 3", 3)
            ),
            selectedValues = listOf(selectedSingleItem2),
            onClick = { selectedItem ->
                selectedSingleItem2 = if (selectedSingleItem2 == selectedItem) null else selectedItem
                println("Single Selection: ${selectedItem.text}")
            },
            multiSelection = false,
            isVisible = false,
        )
    }
}