package com.components.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.grid.data.TTGridItemData
import com.components.grid.item.TTDeletableGridItem
import com.components.text.AXHeaderTextCustom
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TTDeletableGrid(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTGridItemData>,
    selectedItems: List<TTGridItemData>,
    onItemDeleteClick: (id: Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (title.isNotEmpty()) {
            AXHeaderTextCustom(
                text = title,
                fontSize = 20.sp
            )
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                TTDeletableGridItem(
                    item = item,
                    onDeleteClick = onItemDeleteClick,
                    isSelected = selectedItems.contains(item)
                )
            }
        }
    }
}


@VROLightMultiDevicePreview
@Composable
private fun TTDeletableGridPreview() {
    TTDeletableGrid(
        title = "Categorías",
        items = listOf(
            TTGridItemData(id = 0, value = "Test"),
            TTGridItemData(id = 0, value = "Test 1aaaaa"),
            TTGridItemData(id = 0, value = "Test 2"),
            TTGridItemData(id = 0, value = "Test 3wwww"),
            TTGridItemData(id = 0, value = "Test 4"),
            TTGridItemData(id = 0, value = "Test 5sss"),
            TTGridItemData(id = 0, value = "Test 6ddd"),
            TTGridItemData(id = 0, value = "Test 7")
        ),
        onItemDeleteClick = {},
        selectedItems = emptyList()
    )
}