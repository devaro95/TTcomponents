package com.components.text

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.theming.AXTheme
import com.axcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun AXBodyText18(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    )
}

@Composable
fun AXBodyText(
    modifier: Modifier = Modifier,
    text: String,
    minLines: Int = 1,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        modifier = modifier,
        text = text,
        minLines = minLines,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun AXBodyText14(
    modifier: Modifier = Modifier,
    text: String,
    minLines: Int = 1,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        modifier = modifier,
        text = text,
        minLines = minLines,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun AXBodyText14Bold(
    modifier: Modifier = Modifier,
    text: String,
    minLines: Int = 1,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        minLines = minLines,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    )
}

@VROLightMultiDevicePreview
@Composable
private fun AXBodyTextPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AXBodyText18(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXBodyTextBig Test"
        )
        AXBodyText(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXBodyText Test"
        )
        AXBodyText14(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXBodyTextSmall Test"
        )
    }
}
