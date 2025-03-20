package com.components.text

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.components.styles.Font
import com.components.styles.White
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTHeaderTextVariant(
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
fun TTHeaderTextVariant30(
    modifier: Modifier = Modifier,
    text: String,
) {
    TTHeaderTextVariant(
        modifier = modifier,
        text = text,
        fontSize = 30.sp
    )
}

@Composable
fun TTHeaderText30(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
fun TTHeaderText24(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
fun TTHeaderText16(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
fun TTHeaderText18(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
fun TTHeaderText14(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
fun TTHeaderTextCustom(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    color: Color = TTTheme.colorScheme.primaryColor,
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
private fun TTHeaderTextPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TTHeaderTextVariant30(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "TTHeaderTextVariant Test"
        )
        TTHeaderText24(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "TTHeaderTextVeryBig Test"
        )
        TTHeaderText16(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "TTHeaderTextBig Test"
        )
        TTHeaderText18(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "TTHeaderTextBig Test"
        )
        TTHeaderText14(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "TTHeaderTextSmall Test"
        )
    }
}
