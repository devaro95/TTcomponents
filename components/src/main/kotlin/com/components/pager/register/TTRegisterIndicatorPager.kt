package com.components.pager.register

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
import com.components.styles.White
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTRegisterIndicatorPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
) {
    Row(
        modifier = modifier.height(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val isSelectedItem = pagerState.currentPage >= iteration
            val color = if (isSelectedItem) TTTheme.colorScheme.secondaryColor else White
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .border(2.dp, TTTheme.colorScheme.primaryColor, CircleShape)
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
fun ZQRegisterIndicatorPagerPreview() {
    val pagerState = rememberPagerState(
        pageCount = { 3 },
        initialPage = 1
    )
    TTRegisterIndicatorPager(pagerState = pagerState)
}
