package com.components.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.theming.TTTheme
import com.theming.colors.TTPagerIndicatorColors
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTPagerIndicator` is a composable function that creates an indicator for a `TTPager`.
 *
 * This component displays a row of indicators that correspond to the pages in a `TTPager`.
 * The currently selected page's indicator is highlighted.
 *
 * @param modifier Modifier to apply to the indicator row. Use this to control layout properties,
 *                 such as padding, size, and alignment.
 * @param pagerState The `PagerState` object associated with the `TTPager`. This is used to
 *                   determine the number of pages and the currently selected page.
 *
 * Example Usage:
 * @sample TTPagerIndicatorPreview
 *
 */
@Composable
fun TTPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    selectItemsBefore: Boolean = true,
    colors: TTPagerIndicatorColors = TTTheme.colorScheme.pagerIndicatorColors,
) {
    Row(
        modifier = modifier.height(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val isSelectedItem =
                if (selectItemsBefore) pagerState.currentPage >= iteration
                else pagerState.currentPage == iteration
            val color = if (isSelectedItem) colors.selectedItemColor else colors.unselectedItemColor
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .border(
                        width = 2.dp,
                        color =
                            if (isSelectedItem) colors.selectedItemBorder
                            else colors.unselectedItemBorder, CircleShape
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(color)
                    .height(16.dp)
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
fun TTPagerIndicatorPreview() {
    val pagerState = rememberPagerState(
        pageCount = { 3 },
        initialPage = 1
    )
    TTPagerIndicator(pagerState = pagerState)
}
