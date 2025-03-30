package com.components.card.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.components.card.TTCardElevated
import com.components.card.selector.model.TTCardSelectorItem
import com.components.text.TTHeaderText16
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardSelector` is a composable function that creates a selectable card item,
 * suitable for single or multi-selection scenarios.
 *
 * This component provides a visually distinct card that can be selected or deselected by the user.
 * It displays a text label and a selection indicator (a circle) that changes based on whether the
 * card is selected.
 *
 * @param modifier Modifier to apply to the outer `TTCardElevated`.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param item The `TTCardSelectorItem` object containing the data for this card, mainly the text to display.
 * @param selected A boolean indicating whether the card is currently selected.
 * @param onClick Lambda that is invoked when the card is clicked. It provides the `TTCardSelectorItem`
 *                associated with the card.
 * @param multiSelection A boolean indicating whether the card is part of a multi-selection group.
 *                       If true, the selection indicator will be a square. If false, it will be a circle.
 *
 * Example Usage:
 * @sample TTCardSelectorPreview
 *
 */
@Composable
fun TTCardSelector(
    modifier: Modifier = Modifier,
    item: TTCardSelectorItem,
    selected: Boolean,
    onClick: (TTCardSelectorItem) -> Unit,
    multiSelection: Boolean = false,
) {
    TTCardElevated(
        modifier.fillMaxWidth(),
        onClick = { if (!selected || multiSelection) onClick(item) }
    ) {
        Box(
            modifier = Modifier
                .padding(
                    horizontal = 24.dp,
                    vertical = 24.dp
                )
                .fillMaxWidth()
        ) {
            TTHeaderText16(
                modifier = Modifier.align(Alignment.CenterStart),
                text = item.text
            )
            if (!multiSelection) {
                Column(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(16.dp)
                        .border(1.dp, TTTheme.colorScheme.secondaryColor, RoundedCornerShape(100.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (selected) {
                        Spacer(
                            Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(TTTheme.colorScheme.secondaryColor)
                        )
                    }
                }
            } else {
                Column(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(16.dp)
                        .border(1.dp, TTTheme.colorScheme.secondaryColor),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (selected) {
                        Spacer(
                            Modifier
                                .size(10.dp)
                                .background(TTTheme.colorScheme.secondaryColor)
                        )
                    }
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardSelectorPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        var isSelectedSingle by remember { mutableStateOf(true) }
        TTCardSelector(
            item = TTCardSelectorItem("Single selected", 1),
            selected = isSelectedSingle,
            onClick = {
                isSelectedSingle = !isSelectedSingle
            },
            multiSelection = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        var isSelectedSingleUnselected by remember { mutableStateOf(false) }
        TTCardSelector(
            item = TTCardSelectorItem("Single unselected", 2),
            selected = isSelectedSingleUnselected,
            onClick = {
                isSelectedSingleUnselected = !isSelectedSingleUnselected
            },
            multiSelection = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        var isSelectedMulti by remember { mutableStateOf(true) }
        TTCardSelector(
            item = TTCardSelectorItem("Multi selected", 3),
            selected = isSelectedMulti,
            onClick = {
                isSelectedMulti = !isSelectedMulti
            },
            multiSelection = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        var isSelectedMultiUnselected by remember { mutableStateOf(false) }
        TTCardSelector(
            item = TTCardSelectorItem("Multi Unselected", 4),
            selected = isSelectedMultiUnselected,
            onClick = {
                isSelectedMultiUnselected = !isSelectedMultiUnselected
            },
            multiSelection = true
        )
    }
}