package com.components.picker

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.components.text.TTHeaderText14
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTListPicker(
    modifier: Modifier = Modifier,
    itemList: List<TTListItemData>,
    itemSelectedList: List<TTListItemData>,
    onClick: (id: Int) -> Unit,
) {
    Column(modifier = modifier) {
        itemList.forEach {
            Row(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { onClick(it.id) },
                    )
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                TTHeaderText14(
                    modifier = Modifier.weight(1f),
                    text = it.value
                )
                Box(
                    modifier = Modifier
                        .border(1.dp, TTTheme.colorScheme.primaryColor, CircleShape)
                        .clip(CircleShape)
                        .size(22.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (it in itemSelectedList) TTTheme.colorScheme.secondaryColor else TTTheme.colorScheme.background
                            )
                            .size(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

data class TTListItemData(
    val value: String,
    val id: Int,
)

@VROLightMultiDevicePreview
@Composable
private fun TTListPickerPreview() {
    TTListPicker(
        itemList = listOf(
            TTListItemData(
                value = "España",
                id = 0
            ),
            TTListItemData(
                value = "Alemania",
                id = 1
            ),
            TTListItemData(
                value = "Francia",
                id = 2
            ),
            TTListItemData(
                value = "Estados Unidos",
                id = 3
            )
        ),
        itemSelectedList = listOf(
            TTListItemData(
                value = "Alemania",
                id = 1
            ),
            TTListItemData(
                value = "Estados Unidos",
                id = 3
            )
        ),
        onClick = {}
    )
}