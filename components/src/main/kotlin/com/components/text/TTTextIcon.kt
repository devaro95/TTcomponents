package com.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTTextPreview() {
    TTTextIcon(
        iconRes = R.drawable.ic_add,
        text = stringResource(id = R.string.button_add_section),
    )
}

@Composable
fun TTTextIcon(
    modifier: Modifier = Modifier,
    iconRes: Int,
    text: String,
    onClick: (() -> Unit)? = null,
    contentColor: Color? = null,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        TTIcon(
            iconRes = iconRes,
            size = 26.dp,
            onClick = onClick,
            tint = contentColor
        )
        TTBodyText(
            modifier = Modifier.padding(start = 8.dp),
            text = text,
            color = contentColor ?: TTTheme.colorScheme.primaryColor
        )
    }
}