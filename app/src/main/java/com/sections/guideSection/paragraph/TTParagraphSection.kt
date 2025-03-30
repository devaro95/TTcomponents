package com.sections.guideSection.paragraph

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.paragraph.TTParagraph
import com.mock.textLongMock
import com.mock.titleMock

@Composable
fun TTParagraphSection() {
    Column {
        TTParagraph(
            title = titleMock,
            text = textLongMock
        )
    }
}
