package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.TTButtonIconSquare
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTButtonIconSquareSection() {
    Column {
        Section(title = "TTButtonIconSquare with only icon") {
            TTButtonIconSquare(
                iconRes = R.drawable.ic_like_empty,
                onClick = {}
            )
        }
        Section(title = "TTButtonIconSquare with text and icon") {
            TTButtonIconSquare(
                iconRes = R.drawable.ic_like_empty,
                onClick = {},
                text = "10.3M"
            )
        }
    }
}
