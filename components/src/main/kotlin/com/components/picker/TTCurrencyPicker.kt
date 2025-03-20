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
import androidx.compose.ui.unit.sp
import com.components.text.*
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTCurrencyPicker(
    modifier: Modifier = Modifier,
    itemList: List<TTCurrencyItemData>,
    itemSelected: TTCurrencyItemData?,
    onClick: (id: Int) -> Unit,
) {
    Column(modifier = modifier.background(TTTheme.colorScheme.background)) {
        itemList.forEach {
            Row(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { onClick(it.id) },
                    )
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(TTTheme.colorScheme.secondaryColor)
                ) {
                    TTHeaderTextVariant(
                        modifier = Modifier.align(Alignment.Center),
                        text = it.symbol,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TTHeaderText14(text = it.value + " - ")
                    TTBodyText18(text = it.name)
                }
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
                                if (it == itemSelected) TTTheme.colorScheme.secondaryColor else TTTheme.colorScheme.background
                            )
                            .size(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

data class TTCurrencyItemData(
    val value: String,
    val name: String,
    val symbol: String,
    val id: Int,
)

@VROLightMultiDevicePreview
@Composable
private fun TTCurrencyPickerPreview() {
    TTCurrencyPicker(
        itemList = listOf(
            TTCurrencyItemData(
                value = "EUR",
                name = "Euro",
                symbol = "€",
                id = 0
            ),
            TTCurrencyItemData(
                value = "ARS",
                name = "Peso argentino",
                symbol = "$",
                id = 1
            ),
            TTCurrencyItemData(
                value = "KHR",
                name = "Riel camboyano",
                symbol = "៛",
                id = 2
            ),
            TTCurrencyItemData(
                value = "EGP ",
                name = "Libra egipcia",
                symbol = "£",
                id = 3
            )
        ),
        itemSelected = TTCurrencyItemData(
            value = "ARS",
            name = "Peso argentino",
            symbol = "$",
            id = 1
        ),
        onClick = {}
    )
}