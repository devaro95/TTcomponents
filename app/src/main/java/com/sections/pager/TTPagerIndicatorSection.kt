package com.sections.pager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.components.pager.TTPagerIndicator
import com.sections.Section

@Composable
fun TTPagerIndicatorSection() {
    val pagerState = rememberPagerState(
        pageCount = { 3 },
        initialPage = 1
    )

    Column {
        Section(title = "TTPager") {
            TTPagerIndicator(pagerState = pagerState)
        }
    }
}
