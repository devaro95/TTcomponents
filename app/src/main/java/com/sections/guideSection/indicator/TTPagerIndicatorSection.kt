package com.sections.guideSection.indicator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.components.indicator.TTStepperTextIndicator
import com.sections.Section

@Composable
fun TTStepperTextIndicatorSection() {
    Column {
        Section(
            title = "TTStepperTextIndicator"
        ) {
            val itemList = listOf("Item 1", "Item 2", "Item 3")
            val pagerState = rememberPagerState(pageCount = { itemList.size })
            TTStepperTextIndicator(pagerState = pagerState, itemList = itemList, onAddClick = {})
        }
    }
}
