package com.sections.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.counter.TTCounter
import com.sections.Section
import com.vro.constants.INT_ONE

@Composable
fun TTCounterSection() {
    var value by remember { mutableIntStateOf(value = INT_ONE) }
    Column {
        Section(title = "TTCounter") {
            TTCounter(
                value = value,
                onAddClick = { value = value.inc() },
                onSubtract = { value = value.dec() }
            )
        }
    }
}