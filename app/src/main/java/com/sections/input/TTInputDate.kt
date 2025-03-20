package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.input.TTInputCurrency
import com.components.input.TTInputDate
import com.ttcomponents.app.R
import com.utils.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputDateSection() {
    Column {
        Section(title = "TTInputDate empty") {
            TTInputDate(
                firstValue = null,
                secondValue = null,
                onFirstClick = { println("First date clicked (Example 4)") },
                onSecondClick = { println("Second date clicked (Example 4)") }
            )
        }
        Section(title = "TTInputCurrency with departure value") {
            TTInputDate(
                firstValue = "10/10/2024",
                secondValue = null,
                onFirstClick = { println("First date clicked (Example 3)") },
                onSecondClick = { println("Second date clicked (Example 3)") }
            )
        }
        Section(title = "TTInputCurrency with arrival value") {
            TTInputDate(
                firstValue = null,
                secondValue = "25/10/2024",
                onFirstClick = { println("First date clicked (Example 2)") },
                onSecondClick = { println("Second date clicked (Example 2)") }
            )
        }
        Section(title = "TTInputCurrency filled") {
            TTInputDate(
                firstValue = "15/10/2024",
                secondValue = "20/10/2024",
                onFirstClick = { println("First date clicked (Example 1)") },
                onSecondClick = { println("Second date clicked (Example 1)") }
            )
        }
        Section(title = "TTInputCurrency error") {
            TTInputDate(
                firstValue = "01/01/2024",
                secondValue = "02/01/2024",
                isError = true,
                onFirstClick = { println("First date clicked (Example 5)") },
                onSecondClick = { println("Second date clicked (Example 5)") }
            )
        }
    }
}