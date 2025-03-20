package com.sections.guideSection.indicator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.indicator.TTPagerIndicator
import com.utils.Section

@Composable
fun TTPagerIndicatorSection() {
    Column {
        Section(
            title = "TTPagerIndicator"
        ) {
            val itemList = listOf("Item 1", "Item 2", "Item 3")
            val pagerState = rememberPagerState(pageCount = { itemList.size })
            TTPagerIndicator(pagerState = pagerState, itemList = itemList, onAddClick = {})
        }
    }
}