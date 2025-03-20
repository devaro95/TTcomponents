package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.button.TTButtonIconSquare
import com.ttcomponents.app.R
import com.utils.Section

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