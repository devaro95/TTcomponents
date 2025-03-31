package com.components.text

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.styles.Font
import com.theming.AXTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun AXHeaderTextVariant(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    fontSize: TextUnit,
) {
    Text(
        modifier = modifier,
        text = text,
        color = White,
        fontSize = fontSize,
        textAlign = textAlign,
        fontFamily = Font,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun AXHeaderTextVariant30(
    modifier: Modifier = Modifier,
    text: String,
) {
    AXHeaderTextVariant(
        modifier = modifier,
        text = text,
        fontSize = 30.sp
    )
}

@Composable
fun AXHeaderText30(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.displayLarge,
        color = color
    )
}

@Composable
fun AXHeaderText24(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.displayMedium,
        color = color
    )
}

@Composable
fun AXHeaderText16(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineMedium,
        color = color
    )
}

@Composable
fun AXHeaderText18(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineLarge,
        color = color
    )
}

@Composable
fun AXHeaderText14(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineSmall,
        color = color
    )
}

@Composable
fun AXHeaderTextCustom(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = AXTheme.colorScheme.primaryColor,
    fontSize: TextUnit,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.headlineSmall,
        color = color,
        fontSize = fontSize
    )
}

@VROLightMultiDevicePreview
@Composable
private fun AXHeaderTextPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AXHeaderTextVariant30(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXHeaderTextVariant Test"
        )
        AXHeaderText24(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXHeaderTextVeryBig Test"
        )
        AXHeaderText16(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXHeaderTextBig Test"
        )
        AXHeaderText18(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXHeaderTextBig Test"
        )
        AXHeaderText14(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "AXHeaderTextSmall Test"
        )
    }
}
