package com.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theming.TTTheme
import com.theming.colors.TTButtonColors

@Composable
fun TTButtonText(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.NORMAL,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(buttonType.height),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.buttonBackground
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = buttonType.fontSize,
            color = colors.buttonText
        )
    }
}

@Composable
@Preview
private fun TTButtonTextPreview() {
    TTButtonText(text = "Example") {}
}