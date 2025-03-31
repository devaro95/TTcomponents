package com.components.paragraph

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.text.AXBodyText
import com.components.text.AXHeaderText18
import com.mock.textLongMock
import com.mock.titleMock

/**
 * A composable that displays a paragraph with a header and body text.
 *
 * This composable is designed to display a block of text that includes a header (title)
 * and a body (paragraph). It uses the [AXHeaderText18] composable for the title and
 * the [AXBodyText] composable for the paragraph text.
 *
 * @param modifier Modifier to be applied to the paragraph.
 * @param title The text to display as the header of the paragraph.
 * @param text The text to display as the body of the paragraph.
 *
 * Example usage:
 * @sample TTParagraphPreview
 */
@Composable
fun TTParagraph(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
) {
    Column(modifier = modifier) {
        AXHeaderText18(text = title)
        AXBodyText(
            modifier = Modifier.padding(top = 4.dp),
            text = text
        )
    }
}

/**
 * Example usage of the TTParagraph composable.
 */
@Preview
@Composable
private fun TTParagraphPreview() {
    TTParagraph(
        title = titleMock,
        text = textLongMock
    )
}