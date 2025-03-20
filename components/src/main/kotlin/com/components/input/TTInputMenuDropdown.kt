package com.components.input

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import com.components.icon.TTIcon
import com.components.styles.*
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.constants.EMPTY_STRING

/**
 * A custom dropdown menu input field component.
 *
 * This composable function creates a dropdown menu that can be used to select an item from a list.
 * It is based on the `ExposedDropdownMenuBox` and `ExposedDropdownMenu` components from Material 3.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param items The list of items to be displayed in the dropdown menu. Each item is of type [TTInputMenuDropdownItemData].
 * @param placeholder The placeholder text to be displayed when no item is selected.
 * @param selectedItem The currently selected item. If provided, its `text` will be displayed in the input field.
 * @param selectedPosition The position of the selected item in the `items` list. If provided, the item at this position will be displayed.
 * @param onItemSelected A callback function to be invoked when an item is selected. It receives the selected item as a parameter.
 * @param onClick A callback function to be invoked when the input field is clicked. If provided, the dropdown menu will not automatically expand/collapse on click, and the control is delegated to the parent Composable.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTInputMenuDropdown(
    modifier: Modifier = Modifier,
    items: List<TTInputMenuDropdownItemData>,
    placeholder: String = EMPTY_STRING,
    selectedItem: TTInputMenuDropdownItemData? = null,
    selectedPosition: Int? = null,
    onItemSelected: ((TTInputMenuDropdownItemData) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Column(modifier = modifier) {
        var isExpanded by remember { mutableStateOf(false) }
        var isOpened by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                if (onClick == null) isExpanded = !isExpanded
                isOpened = !isOpened
            },
            modifier = Modifier
                .height(56.dp)
                .border(
                    border = BorderStroke(1.dp, InputBorder),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(SecondaryBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .menuAnchor()
                    .clickable { onClick?.invoke() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    if (placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            maxLines = 1,
                            style = TextStyle(
                                color = TTTheme.colorScheme.primaryColor,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.main_font_medium))
                            ),
                            overflow = TextOverflow.Ellipsis,
                            color = Placeholder
                        )
                    }
                    if (selectedItem != null || selectedPosition != null) {
                        Text(
                            text = selectedPosition?.let {
                                items[selectedPosition].text
                            } ?: run {
                                selectedItem?.text ?: placeholder
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                        )
                    }
                }
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    TTIcon(
                        iconRes = R.drawable.ic_back,
                        modifier = if (isOpened) Modifier.rotate(90f)
                        else Modifier.rotate(-90f),
                        tint = InputLegend
                    )
                }
            }
            if (onClick == null) {
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                        isOpened = !isOpened
                    },
                    modifier = Modifier.background(SecondaryBackground)
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            text = {
                                Text(item.text)
                            },
                            onClick = {
                                isExpanded = false
                                onItemSelected?.invoke(item)
                            },
                            colors = MenuDefaults.itemColors(
                                textColor = TTTheme.colorScheme.secondaryColor
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputMenuDropdownPreview() {
    val items = listOf(
        TTInputMenuDropdownItemData(0, "Option 1"),
        TTInputMenuDropdownItemData(1, "Option 2"),
        TTInputMenuDropdownItemData(2, "Option 3"),
        TTInputMenuDropdownItemData(3, "This is a very long option to test the ellipsis"),
    )
    var selectedPosition by remember { mutableStateOf<Int?>(null) }
    var selectedPosition2 by remember { mutableIntStateOf(2) }
    Column {
        TTInputMenuDropdown(
            items = items,
            onItemSelected = { item ->
                selectedPosition = items.indexOf(item)
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTInputMenuDropdown(
            placeholder = "Select an option",
            items = items,
            onItemSelected = { item ->
                selectedPosition = items.indexOf(item)
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTInputMenuDropdown(
            placeholder = "Select an option",
            items = items,
            selectedPosition = selectedPosition2,
            onItemSelected = { item ->
                selectedPosition2 = items.indexOf(item)
            },
        )
    }
}