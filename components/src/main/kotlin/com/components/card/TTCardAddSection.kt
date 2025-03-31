package com.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.paragraph.TTParagraph
import com.components.styles.SectionDetailCardColor
import com.components.text.AXTextIcon
import com.mock.textLongMock
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@Deprecated(
    message = "Old Used form",
    replaceWith = ReplaceWith("Replace with TTSectionAdd")
)
@Composable
fun TTSectionAddCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    horizontalPadding: Dp? = null,
    sectionContent: @Composable ColumnScope.() -> Unit,
) {
    TTCardElevated(
        background = SectionDetailCardColor,
        modifier = modifier.padding(bottom = 16.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(
                top = 8.dp,
                start = horizontalPadding ?: 8.dp,
                end = horizontalPadding ?: 8.dp,
                bottom = 12.dp
            )
        ) {
            sectionContent.invoke(this)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                AXTextIcon(
                    iconRes = R.drawable.ic_add,
                    text = stringResource(id = R.string.button_add_section),
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTSectionAddCardPreview() {
    TTSectionAddCard(
        sectionContent = {
            TTParagraph(
                title = titleMock,
                text = textLongMock
            )
        },
        onClick = {},
    )
}
