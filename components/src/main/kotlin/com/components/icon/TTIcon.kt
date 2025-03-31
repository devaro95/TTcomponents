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

/**
 * `TTIcon` is a composable function that displays an icon with customizable properties.
 *
 * This component renders an icon from a drawable resource with options to set its size,
 * content description, click action, and tint color.
 *
 * @param modifier Modifier to apply to the icon. Use this to control layout properties such as
 *                 padding and positioning. Note that size should be controlled via the `size`
 *                 parameter, not directly through this modifier.
 * @param iconRes The resource ID of the drawable to be used as the icon.
 * @param size Optional size (width and height) of the icon. If `null`, the icon will use its
 *             default size.
 * @param contentDescription Optional content description for accessibility.
 * @param onClick Optional lambda that is invoked when the icon is clicked. If `null`, the icon
 *                will not be clickable.
 * @param tint Optional tint color for the icon. Defaults to the primary color from the
 *             `TTTheme.colorScheme`.
 *
 * Example Usage:
 * @sample TTIconPreview
 * @deprecated This composable is deprecated. Use [AXIcon] instead for better performance
 * and more customization options.
 *
 */
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

@VROLightMultiDevicePreview
@Composable
private fun TTIconPreview() {
    TTIcon(
        iconRes = R.drawable.ic_delete,
        onClick = {}
    )
}