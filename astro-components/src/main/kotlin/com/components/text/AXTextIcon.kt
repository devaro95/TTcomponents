package com.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.theming.AXTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun AXTextPreview() {
    AXTextIcon(
        iconRes = R.drawable.ic_add,
        text = stringResource(id = R.string.button_add_section),
    )
}

@Composable
fun AXTextIcon(
    modifier: Modifier = Modifier,
    iconRes: Int,
    text: String,
    onClick: (() -> Unit)? = null,
    contentColor: Color? = null,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        AXIcon(
            iconRes = iconRes,
            size = 26.dp,
            onClick = onClick,
            tint = contentColor
        )
        AXBodyText(
            modifier = Modifier.padding(start = 8.dp),
            text = text,
            color = contentColor ?: AXTheme.colorScheme.primaryColor
        )
    }
}