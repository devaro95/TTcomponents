package com.components.listitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.divider.TTLineDivider
import com.components.icon.AXIcon
import com.components.text.AXBodyText
import com.components.text.AXHeaderText16
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTSectionListItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    clickable: Boolean = false,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .createClickModifier(onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                AXHeaderText16(text = title)
                AXBodyText(
                    modifier = Modifier.padding(top = 4.dp),
                    text = description
                )
            }
            if (clickable) {
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    AXIcon(
                        iconRes = R.drawable.ic_back,
                        modifier = Modifier.rotate(180f)
                    )
                }
            }
        }
        TTLineDivider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
private fun Modifier.createClickModifier(clickListener: (() -> Unit)?): Modifier {
    return if (clickListener != null)
        clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { clickListener.invoke() },
        )
    else this
}

@VROLightMultiDevicePreview
@Composable
private fun TTSectionListItemPreview() {
    TTSectionListItem(
        title = "Párrafo",
        description = "Párrafos simples para tu guía.",
        onClick = {},
        clickable = true
    )
}