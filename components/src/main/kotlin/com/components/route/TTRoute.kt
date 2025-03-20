package com.components.route

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.styles.White
import com.components.text.*
import com.mock.*
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTRoutePreview() {
    TTRoute(
        title = titleMock,
        routeItems = listOf(
            TTRouteItemData(
                title = titleMock,
                text = textLongMock
            ),
            TTRouteItemData(
                title = titleMock,
                text = textMock
            )
        )
    )
}

@Composable
fun TTRoute(
    modifier: Modifier = Modifier,
    title: String,
    routeItems: List<TTRouteItemData>,
) {
    Column(modifier) {
        if (title.isNotEmpty()) {
            TTHeaderText18(
                modifier = Modifier.padding(bottom = 8.dp),
                text = title
            )
        }
        routeItems.forEachIndexed { index, item ->
            TTRouteItem(item, index.inc(), index.inc() == routeItems.size)
        }
    }
}

@Composable
private fun TTRouteItem(item: TTRouteItemData, position: Int, islast: Boolean = false) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = TTTheme.colorScheme.primaryColor
                ),
                modifier = Modifier.size(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = position.toString(),
                        color = White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            if (!islast) {
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    color = TTTheme.colorScheme.primaryColor,
                    thickness = 1.dp
                )
            }
        }
        Column(
            modifier = Modifier.padding(
                start = 8.dp,
                bottom = 8.dp
            )
        ) {
            TTHeaderText16(text = item.title)
            TTBodyText(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .padding(bottom = 8.dp),
                text = item.text
            )
        }
    }
}

data class TTRouteItemData(
    val title: String,
    val text: String,
)