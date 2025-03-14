package com.components.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LineDividerPreview() {
    TTLineDivider()
}

@Composable
fun TTLineDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier,
        color = Color.Gray,
        thickness = 1.dp
    )
}