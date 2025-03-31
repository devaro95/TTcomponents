package com.components.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttcomponents.app.R
import com.components.text.AXBodyText
import com.components.text.AXHeaderText14
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSearchPreview() {
    TTSearch(
        itemList = listOf(titleMock, titleMock, titleMock),
        onItemClick = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTSearch(
    modifier: Modifier = Modifier,
    itemList: List<String>,
    onItemClick: (String) -> Unit,
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(itemList) {
                Row(modifier = Modifier.clickable { onItemClick(it) }) {
                    Text(
                        modifier = modifier,
                        text = it,
                        fontFamily = FontFamily(Font(R.font.main_font_medium)),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}