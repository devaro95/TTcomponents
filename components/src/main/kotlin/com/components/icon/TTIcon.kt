package com.components.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTIconPreview() {
    TTIcon(
        iconRes = R.drawable.ic_delete,
        onClick = {}
    )
}

@Composable
fun TTIcon(
    modifier: Modifier = Modifier,
    iconRes: Int,
    size: Dp? = null,
    contentDescription: String? = null,
    onClick: (() -> Unit)? = null,
    tint: Color? = TTTheme.colorScheme.primaryColor,
) {
    Column(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { onClick?.invoke() }
        )
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = tint ?: MaterialTheme.colorScheme.primary,
            modifier = modifier.setSize(size)
        )
    }
}

fun Modifier.setSize(size: Dp? = null): Modifier {
    return size?.let {
        size(it)
    } ?: this
}
