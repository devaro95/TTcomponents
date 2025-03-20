package com.components.indicator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theming.TTTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTLineIndicator(
    modifier: Modifier = Modifier,
    state: PagerState,
    pages: Int,
) {
    Row(
        modifier = modifier
            .width(32.dp * pages)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        for (i in 0 until pages) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .height(8.dp)
                    .background(
                        color = TTTheme.colorScheme.primaryColor,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

            }
        }
    }
}