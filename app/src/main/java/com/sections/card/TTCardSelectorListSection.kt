package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.card.selector.TTCardSelectorList
import com.components.card.selector.model.TTCardSelectorItem
import com.components.card.selector.model.TTCardSelectorOtherItem
import com.mock.titleMock
import com.sections.Section

@Composable
fun TTCardSelectorListSection() {
    Column {
        Section(title = "TTCardSelectorList with header") {
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
        }
        Section(title = "TTCardSelector with header and subheader") {
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
        }
        Section(title = "TTCardSelector with other option") {
            var selectedMultiItems2 by remember { mutableStateOf<List<TTCardSelectorItem?>>(emptyList()) }
            var otherValue by remember { mutableStateOf("") }
            TTCardSelectorList(
                header = "$titleMock (Multi-Selection)",
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
        }
        Section(title = "TTCardSelector without title or header") {
            var selectedMultiItems2 by remember { mutableStateOf<List<TTCardSelectorItem?>>(emptyList()) }
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
                isVisible = true
            )
        }
    }
}
