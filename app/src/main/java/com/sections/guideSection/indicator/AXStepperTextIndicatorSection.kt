package com.sections.guideSection.indicator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.components.indicator.AXStepperTextIndicator
import com.sections.Section

@Composable
fun AXStepperTextIndicatorSection() {
    Column {
        Section(
            title = "AXStepperTextIndicator"
        ) {
            val itemList = listOf("Item 1", "Item 2", "Item 3")
            val pagerState = rememberPagerState(pageCount = { itemList.size })
            AXStepperTextIndicator(pagerState = pagerState, itemList = itemList, onAddClick = {})
        }
    }
}
