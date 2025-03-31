package com.components.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.grid.data.TTGridItemData
import com.components.input.AXInput
import com.components.text.AXHeaderTextCustom
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TTSearchGrid(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTGridItemData>,
    selectedItems: List<TTGridItemData>,
    inputPlaceholder: String,
    onItemClick: (id: Int) -> Unit
) {
    var filter by remember { mutableStateOf(EMPTY_STRING) }

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
        AXInput(
            value = filter,
            placeholder = inputPlaceholder,
            onChange = { filter = it })
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.filter { it.value.contains(filter) }.forEach { item ->
                TTGridItem(
                    item = item,
                    onClick = onItemClick,
                    isSelected = selectedItems.contains(item)
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTGridItemPreview() {
    Row(
        Modifier
            .padding(16.dp)
    ) {
        TTGridItem(
            TTGridItemData(
                id = 0, value = "Test"
            ),
            onClick = {},
            isSelected = true
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTSearchGridPreview() {
    TTSearchGrid(
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
        onItemClick = {},
        selectedItems = emptyList(),
        inputPlaceholder = "Buscar"
    )
}