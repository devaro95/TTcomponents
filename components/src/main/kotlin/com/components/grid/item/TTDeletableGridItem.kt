package com.components.grid.item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.components.grid.data.TTGridItemData
import com.components.icon.TTIcon
import com.components.styles.*
import com.components.text.AXHeaderText14
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTDeletableGridItem(
    item: TTGridItemData,
    onDeleteClick: (id: Int) -> Unit,
    isSelected: Boolean,
) {
    Box {
        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    end = 8.dp
                )
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) TTTheme.colorScheme.secondaryColor else TTTheme.colorScheme.background)
                .border(2.dp, TTTheme.colorScheme.secondaryColor, RoundedCornerShape(10.dp))
        ) {
            AXHeaderText14(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                text = item.value,
                color = if (isSelected) White else TTTheme.colorScheme.primaryColor
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .border(1.dp, TTTheme.colorScheme.background, CircleShape)
                .clip(CircleShape)
                .background(TTTheme.colorScheme.primaryColor)
                .size(20.dp),
        ) {
            TTIcon(
                modifier = Modifier.padding(6.dp),
                iconRes = R.drawable.ic_cross,
                tint = White,
                onClick = { onDeleteClick(item.id) }
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTDeletableGridItemPreview() {
    TTDeletableGridItem(
        TTGridItemData(
            id = 0, value = "Test"
        ),
        onDeleteClick = {},
        isSelected = true
    )
}