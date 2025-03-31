package com.components.input

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.components.text.AXBodyText
import com.components.text.AXHeaderTextVariant
import com.theming.AXTheme
import com.theming.colors.AXInputColors

/**
 * A composable that provides a currency picker with a dropdown menu for selecting a price and a currency.
 *
 * This composable allows users to select a price from a list of options and choose a currency.
 * It displays a dropdown menu for price selection and a separate clickable area for currency selection.
 *
 * @param modifier Modifier to be applied to the currency picker.
 * @param items A list of [AXInputMenuDropdownItemData] representing the available price options.
 * @param selected The currently selected [AXInputMenuDropdownItemData], or null if none is selected.
 * @param placeholder The placeholder text to display in the price selection area when no item is selected.
 * @param currency The currently selected currency (e.g., "USD", "EUR").
 * @param symbol The currency symbol to display (e.g., "$", "€").
 * @param onPriceSelected A callback to invoke when a price is selected from the dropdown.
 * @param onCurrencyClick A callback to invoke when the currency selection area is clicked.
 *
 * Example usage:
 * @sample AXInputCurrencyPickerPreview
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AXInputCurrencyPicker(
    modifier: Modifier = Modifier,
    items: List<AXInputMenuDropdownItemData>,
    selected: AXInputMenuDropdownItemData? = null,
    placeholder: String,
    currency: String,
    symbol: String,
    isError: Boolean = false,
    colors: AXInputColors = AXInputColors.defaultColors,
    onPriceSelected: ((AXInputMenuDropdownItemData) -> Unit)? = null,
    onCurrencyClick: () -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .height(56.dp)
            .background(colors.focusedContainerColor)
            .border(
                width = 1.dp,
                color = if (isError) colors.errorBorderColor else colors.borderColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(10.dp)),
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = !isExpanded
            },
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(colors.focusedContainerColor),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .menuAnchor(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                selected?.let {
                    AXBodyText(text = selected.text)
                } ?: run {
                    Text(
                        text = placeholder,
                        maxLines = 1,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.main_font_medium))
                        ),
                        overflow = TextOverflow.Ellipsis,
                        color = colors.placeholderColor
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                AXIcon(
                    modifier = Modifier.rotate(-90f),
                    iconRes = R.drawable.ic_back,
                    onClick = { },
                    tint = colors.placeholderColor
                )
            }
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                },
                modifier = Modifier.background(colors.focusedContainerColor)
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(item.text)
                        },
                        onClick = {
                            isExpanded = false
                            onPriceSelected?.invoke(item)
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = AXTheme.colorScheme.primaryColor,
                        )
                    )
                }
            }
        }
        VerticalDivider(modifier = Modifier.padding(vertical = 16.dp))

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onCurrencyClick() }
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .background(AXTheme.colorScheme.secondaryColor)
            ) {
                AXHeaderTextVariant(
                    modifier = Modifier.align(Alignment.Center),
                    text = symbol,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            AXBodyText(text = currency)
            Spacer(modifier = Modifier.width(16.dp))
            AXIcon(
                modifier = Modifier.rotate(-90f),
                iconRes = R.drawable.ic_back,
                onClick = { onCurrencyClick() },
                tint = colors.placeholderColor
            )
        }
    }
}

/**
 * Example usage of the AXInputCurrencyPicker composable.
 */
@Composable
@Preview
private fun AXInputCurrencyPickerPreview() {
    Column {
        AXInputCurrencyPicker(
            placeholder = "Precio",
            currency = "USD",
            items = listOf(
                AXInputMenuDropdownItemData(value = 1, "asd"),
                AXInputMenuDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        AXInputCurrencyPicker(
            selected = AXInputMenuDropdownItemData(value = 1, "asd"),
            placeholder = "Precio",
            currency = "EUR",
            items = listOf(
                AXInputMenuDropdownItemData(value = 1, "asd"),
                AXInputMenuDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        AXInputCurrencyPicker(
            selected = AXInputMenuDropdownItemData(value = 1, "asd"),
            placeholder = "Precio",
            currency = "EUR",
            items = listOf(
                AXInputMenuDropdownItemData(value = 1, "asd"),
                AXInputMenuDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
    }
}
