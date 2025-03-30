package com.components.pager

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.pager.model.PagerStepItem
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ZERO

/**
 * `TTPager` is a composable function that creates a horizontal pager (carousel).
 *
 * This component displays a horizontally scrollable list of pages, where each page is defined
 * by an item in the `stepList`. It allows customization of scrolling behavior, the initial
 * page displayed, and other properties.
 *
 * @param modifier Modifier to apply to the pager. Use this to control layout properties, such as
 *                 padding, size, and alignment.
 * @param initialPage The index of the page that should be displayed when the pager is first
 *                    composed. Defaults to `INT_ZERO` (0), the first page.
 * @param userScrollEnabled Whether the user can scroll through the pages. Defaults to `true`.
 * @param stepList A list of `PagerStepItem` objects representing the pages to be displayed. Each
 *                 `PagerStepItem` contains a lambda (`content`) that defines the content of the page.
 *
 * Example Usage:
 * @sample TTPagerPreview
 */
@SuppressLint("ComposableNaming")
@Composable
fun TTPager(
    modifier: Modifier = Modifier,
    initialPage: Int = INT_ZERO,
    userScrollEnabled: Boolean = true,
    stepList: List<PagerStepItem>,
): PagerState {
    val pagerState = rememberPagerState(
        pageCount = { stepList.size },
        initialPage = initialPage
    )
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            pagerSnapDistance = PagerSnapDistance.atMost(INT_ZERO)
        ),
        userScrollEnabled = userScrollEnabled,
        beyondViewportPageCount = INT_ZERO
    ) { page ->
        stepList[page].content()
    }
    return pagerState
}

@VROLightMultiDevicePreview
@Composable
private fun TTPagerPreview() {
    val itemList = listOf(
        PagerStepItem(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TTHeaderText18(text = "This is the first Page")
                    TTBodyText(text = "This is an example of pager content")
                }
            }
        ),
        PagerStepItem(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TTHeaderText18(text = "This is the second Page")
                    TTBodyText(text = "This is an example of pager content")
                }
            }
        ),
    )
    TTPager(
        stepList = itemList
    )
}

