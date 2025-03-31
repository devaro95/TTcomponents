package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.AXInputDate
import com.sections.Section

@Composable
fun AXInputDateSection() {
    Column {
        Section(title = "AXInputDate empty") {
            AXInputDate(
                firstValue = null,
                secondValue = null,
                onFirstClick = { println("First date clicked (Example 4)") },
                onSecondClick = { println("Second date clicked (Example 4)") }
            )
        }
        Section(title = "AXInputCurrency with departure value") {
            AXInputDate(
                firstValue = "10/10/2024",
                secondValue = null,
                onFirstClick = { println("First date clicked (Example 3)") },
                onSecondClick = { println("Second date clicked (Example 3)") }
            )
        }
        Section(title = "AXInputCurrency with arrival value") {
            AXInputDate(
                firstValue = null,
                secondValue = "25/10/2024",
                onFirstClick = { println("First date clicked (Example 2)") },
                onSecondClick = { println("Second date clicked (Example 2)") }
            )
        }
        Section(title = "AXInputCurrency filled") {
            AXInputDate(
                firstValue = "15/10/2024",
                secondValue = "20/10/2024",
                onFirstClick = { println("First date clicked (Example 1)") },
                onSecondClick = { println("Second date clicked (Example 1)") }
            )
        }
        Section(title = "AXInputCurrency error") {
            AXInputDate(
                firstValue = "01/01/2024",
                secondValue = "02/01/2024",
                isError = true,
                onFirstClick = { println("First date clicked (Example 5)") },
                onSecondClick = { println("Second date clicked (Example 5)") }
            )
        }
    }
}
