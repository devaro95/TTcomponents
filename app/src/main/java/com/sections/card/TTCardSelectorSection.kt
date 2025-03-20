package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.card.TTCardSelector
import com.components.card.TTCardSelectorItem
import com.utils.Section

@Composable
fun TTCardSelectorSection() {
    Column {
        Section(title = "TTCardSelector single selected") {
            var isSelectedSingle by remember { mutableStateOf(true) }
            TTCardSelector(
                item = TTCardSelectorItem("Single selected", 1),
                selected = isSelectedSingle,
                onClick = {
                    isSelectedSingle = !isSelectedSingle
                },
                multiSelection = false
            )
        }
        Section(title = "TTCardSelector single unselected") {
            var isSelectedSingleUnselected by remember { mutableStateOf(false) }
            TTCardSelector(
                item = TTCardSelectorItem("Single unselected", 2),
                selected = isSelectedSingleUnselected,
                onClick = {
                    isSelectedSingleUnselected = !isSelectedSingleUnselected
                },
                multiSelection = false
            )
        }
        Section(title = "TTCardSelector multi selected") {
            var isSelectedMulti by remember { mutableStateOf(true) }
            TTCardSelector(
                item = TTCardSelectorItem("Multi selected", 3),
                selected = isSelectedMulti,
                onClick = {
                    isSelectedMulti = !isSelectedMulti
                },
                multiSelection = true
            )
        }
        Section(title = "TTCardSelector multi unselected") {
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
}