package com.components.grid

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.grid.data.TTGridItemData
import com.components.styles.White
import com.components.text.AXHeaderText14
import com.components.text.AXHeaderTextCustom
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TTGrid(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTGridItemData>,
    selectedItems: List<TTGridItemData>,
    onItemClick: (id: Int) -> Unit,
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
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                TTGridItem(
                    item = item,
                    onClick = onItemClick,
                    isSelected = selectedItems.contains(item)
                )
            }
        }
    }
}

@Composable
fun TTGridItem(
    item: TTGridItemData,
    onClick: (id: Int) -> Unit,
    isSelected: Boolean,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) TTTheme.colorScheme.secondaryColor else TTTheme.colorScheme.background)
            .border(2.dp, TTTheme.colorScheme.secondaryColor, RoundedCornerShape(10.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(item.id) },
            )
    ) {
        AXHeaderText14(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            text = item.value,
            color = if (isSelected) White else TTTheme.colorScheme.primaryColor
        )
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
private fun TTGridPreview() {
    TTGrid(
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
        selectedItems = emptyList()
    )
}