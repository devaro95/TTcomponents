package com.components.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theming.TTTheme
import com.vro.constants.EMPTY_STRING

@Composable
fun TTTextBorder(
    modifier: Modifier = Modifier,
    label: String = EMPTY_STRING,
    text: String,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, TTTheme.colorScheme.primaryColor),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
            draggedElevation = 0.dp,
            disabledElevation = 0.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 8.dp
            )
        ) {
            Column {
                if (label.isNotEmpty()) {
                    TTBodyText(
                        text = label,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                TTBodyText(
                    text = text,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun TTTextBorderPreview() {
    Column {
        TTTextBorder(label = "Label", text = "Test with label")
        Spacer(Modifier.height(8.dp))
        TTTextBorder(text = "Test")
    }
}