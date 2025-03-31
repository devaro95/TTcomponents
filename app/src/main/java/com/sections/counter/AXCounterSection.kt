package com.sections.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.counter.AXCounter
import com.sections.Section
import com.vro.constants.INT_ONE

@Composable
fun AXCounterSection() {
    var value by remember { mutableIntStateOf(value = INT_ONE) }
    Column {
        Section(title = "TTCounter") {
            AXCounter(
                value = value,
                onAddClick = { value = value.inc() },
                onSubtract = { value = value.dec() }
            )
        }
    }
}