package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.AXButtonIconSquare
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun AXButtonIconSquareSection() {
    Column {
        Section(title = "AXButtonIconSquare with only icon") {
            AXButtonIconSquare(
                iconRes = R.drawable.ic_like_empty,
                onClick = {}
            )
        }
        Section(title = "AXButtonIconSquare with text and icon") {
            AXButtonIconSquare(
                iconRes = R.drawable.ic_like_empty,
                onClick = {},
                text = "10.3M"
            )
        }
    }
}
