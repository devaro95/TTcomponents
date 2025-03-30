package com.components.indicator

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.button.TTButtonIconSquare
import com.components.text.TTHeaderTextCustom
import com.theming.TTTheme
import com.theming.colors.TTStepperIndicatorColors
import com.ttcomponents.app.R
import kotlinx.coroutines.launch

/**
 * A composable that displays a pager indicator with clickable items.
 *
 * This composable displays a horizontal row of items, each representing a page in a pager.
 * It highlights the currently selected page and provides a clickable interface to navigate
 * between pages. It also includes an optional "add" button.
 *
 * @param modifier Modifier to be applied to the indicator.
 * @param pagerState The [PagerState] to be linked with the indicator.
 * @param itemList The list of strings to be displayed as items in the indicator.
 * @param onAddClick An optional callback to be invoked when the "add" button is clicked. If null, the button will not be displayed.
 *
 * Example usage:
 * @sample TTStepperTextIndicatorPreview
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTStepperTextIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    itemList: List<String>,
    colors: TTStepperIndicatorColors = TTTheme.colorScheme.stepperIndicatorColors,
    onAddClick: (() -> Unit)? = null,
) {

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyRow(
            modifier = modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            state = listState,
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemList.forEachIndexed { position, item ->
                val color = if (pagerState.currentPage == position) colors.selectedItemColor else colors.unselectedItemColor
                val textColor = if (pagerState.currentPage == position) colors.selectedItemTextColor else colors.unselectedItemTextColor
                item {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .border(2.dp, TTTheme.colorScheme.secondaryColor, RoundedCornerShape(16.dp))
                            .background(color)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(position)

                                        val viewportStart =
                                            listState.layoutInfo.viewportStartOffset
                                        val viewportEnd = listState.layoutInfo.viewportEndOffset
                                        val viewportWidth = viewportEnd - viewportStart

                                        val itemInfo =
                                            listState.layoutInfo.visibleItemsInfo.find { it.index == position }
                                        itemInfo?.let { info ->
                                            val itemCenter = info.offset + info.size / 2
                                            val targetScrollOffset =
                                                itemCenter - viewportStart - viewportWidth / 2
                                            listState.animateScrollToItem(
                                                index = position,
                                                scrollOffset = targetScrollOffset
                                            )
                                        }
                                    }
                                },
                            )
                    ) {
                        TTHeaderTextCustom(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                            text = itemList[position],
                            color = textColor,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            onAddClick?.let {
                item {
                    TTButtonIconSquare(
                        iconRes = R.drawable.ic_save_section,
                        text = stringResource(R.string.tab_manage),
                        onClick = it
                    )
                }
            }
        }
    }
}

/**
 * Example usage of the TTStepperTextIndicator composable.
 */
@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTStepperTextIndicatorPreview() {
    Column(modifier = Modifier.fillMaxWidth()) {
        val itemList = listOf("Item 1", "Item 2", "Item 3")
        val pagerState = rememberPagerState(pageCount = { itemList.size })
        TTStepperTextIndicator(pagerState = pagerState, itemList = itemList, onAddClick = {})
    }
}