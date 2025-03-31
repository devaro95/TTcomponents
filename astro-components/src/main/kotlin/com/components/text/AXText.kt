package com.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.axcomponents.app.R
import com.styles.Font
import com.theming.AXTheme

@Composable
fun AXTitleText16(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun AXAddressText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = Color(0xFF7D8B92),
        fontSize = 14.sp,
        textAlign = textAlign,
        fontFamily = Font,
    )
}

@Composable
fun AXItalicText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = AXTheme.colorScheme.primaryColor,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = textAlign,
        fontFamily = Font,
    )
}

@Composable
fun AXErrorText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.error,
        fontSize = 14.sp,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    )
}
