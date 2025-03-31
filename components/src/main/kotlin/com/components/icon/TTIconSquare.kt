package com.components.icon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.text.AXHeaderText14
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTIconSquare(
    modifier: Modifier = Modifier,
    iconRes: Int,
    onClick: () -> Unit = {},
    text: String = EMPTY_STRING,
    iconPadding: Dp = 8.dp,
    iconSize: Dp = 18.dp,
    backgroundColor: Color = TTTheme.colorScheme.background,
    iconTint: Color? = null,
) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (text.isNotEmpty()) {
                AXHeaderText14(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .padding(vertical = 8.dp),
                    text = text
                )
            }
            TTIcon(
                modifier = Modifier.padding(iconPadding),
                iconRes = iconRes,
                size = iconSize,
                onClick = onClick,
                tint = iconTint
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTIconSquarePreview() {
    Column {
        TTIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {}
        )
        TTIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {},
            text = "10.3M"
        )
    }
}
