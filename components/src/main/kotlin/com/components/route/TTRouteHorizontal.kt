package com.components.route

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.card.TTCardElevated
import com.components.styles.White
import com.components.text.*
import com.mock.*
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTRouteHorizontalPreview() {
    Column(Modifier.fillMaxSize()) {
        TTRouteHorizontal(
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTRouteHorizontal(
    title: String,
    routeItems: List<TTRouteItemData>,
) {
    Column {
        if (title.isNotEmpty()) {
            AXHeaderText18(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = title
            )
        }
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(top = 24.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                routeItems.forEachIndexed { index, item ->
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            TTRouteHorizontalItem(item, index.inc())
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TTRouteHorizontalItem(item: TTRouteItemData, position: Int) {
    TTCardElevated(
        background = TTTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
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
                }
                AXHeaderText16(modifier = Modifier.padding(start = 8.dp), text = item.title)
            }
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                    bottom = 8.dp
                )
            ) {
                AXBodyText(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = item.text
                )
            }
        }
    }
}