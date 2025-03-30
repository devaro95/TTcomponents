package com.components.section

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.components.button.TTButtonIconSquare
import com.components.divider.TTSectionDivider
import com.components.paragraph.TTParagraph
import com.components.styles.White
import com.mock.textLongMock
import com.mock.titleMock
import com.theming.TTTheme
import com.theming.colors.TTButtonColors
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTSectionAdd(
    modifier: Modifier = Modifier,
    onSave: () -> Unit,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column {
        content()
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TTButtonIconSquare(
                iconRes = R.drawable.ic_save_section,
                text = stringResource(R.string.configure_section),
                colors = colors.copy(
                    buttonBackground = TTTheme.colorScheme.secondaryColor,
                    buttonText = White,
                ),
                onClick = onSave
            )
        }
    }
    TTSectionDivider(modifier = Modifier.padding(vertical = 32.dp))
}

@VROLightMultiDevicePreview
@Composable
private fun TTSectionAddCardPreview() {
    TTSectionAdd(
        content = {
            TTParagraph(
                title = titleMock,
                text = textLongMock
            )
        },
        onSave = {},
    )
}
