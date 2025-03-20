package com.components.bullet

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.components.text.*
import com.mock.textMock
import com.mock.titleMock
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@VROLightMultiDevicePreview
@Composable
private fun TTBulletPreview() {
    TTBullet(
        title = titleMock,
        text = textMock,
        itemList = listOf(
            TTBulletItemData(
                title = titleMock,
                text = textMock
            ),
            TTBulletItemData(
                title = EMPTY_STRING,
                text = textMock
            ),
            TTBulletItemData(
                title = titleMock,
                text = textMock
            )
        )
    )
}

@Composable
fun TTBullet(
    modifier: Modifier = Modifier,
    title: String,
    text: String = EMPTY_STRING,
    itemList: List<TTBulletItemData>,
) {
    Column(modifier = modifier) {
        TTHeaderText18(text = title)
        if (text.isNotEmpty()) TTBodyText(
            modifier = Modifier.padding(top = 8.dp),
            text = text
        )
        itemList.forEach {
            Row(modifier = Modifier.padding(top = 8.dp)) {
                TTBulletItem(item = it)
            }
        }
    }
}

@Composable
fun TTBulletItem(
    modifier: Modifier = Modifier,
    item: TTBulletItemData,
    bulletColor: Color = TTTheme.colorScheme.primaryColor,
) {
    Row(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 6.dp
                )
                .size(8.dp)
        ) {
            drawCircle(bulletColor)
        }
        Column {
            if (item.title.isNotEmpty()) {
                TTHeaderText16(text = item.title)
            }
            TTBodyText(
                modifier = Modifier.padding(top = if (item.title.isNotEmpty()) 4.dp else 0.dp),
                text = item.text
            )
        }
    }
}

data class TTBulletItemData(
    val title: String = EMPTY_STRING,
    val text: String,
)