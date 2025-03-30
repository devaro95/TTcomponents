package com.components.guide

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.components.button.TTButtonIconSquare
import com.components.guide.guideBuilder.BuildSection
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.indicator.TTStepperTextIndicator
import com.components.styles.White
import com.domain.model.SectionModel
import com.domain.model.TabModel
import com.theming.TTTheme
import com.theming.colors.TTButtonColors
import com.ttcomponents.app.R
import com.vro.constants.INT_ZERO
import kotlin.math.absoluteValue

@Composable
fun TTGuideAddSection(
    itemList: List<TabModel>,
    onAddSection: (position: Int, tab: TabModel) -> Unit,
    onAddTab: (() -> Unit)? = null,
) {
    if (itemList.size == 1 && itemList.first().title.isEmpty()) {
        Column {
            onAddTab?.let {
                AddButton(
                    onClick = it,
                    arrangement = Arrangement.Center,
                    text = stringResource(R.string.add_section_configure_tab)
                )
            }
            AddButton(onClick = { onAddSection(INT_ZERO, itemList[INT_ZERO]) })
            BuildSections(
                modifier = Modifier.padding(top = 24.dp),
                sectionList = itemList.first().sections,
                onAddSection = { position -> onAddSection(position, itemList[INT_ZERO]) }
            )
        }
    } else {
        val pagerState = rememberPagerState(pageCount = { itemList.size })

        TTStepperTextIndicator(
            modifier = Modifier.padding(bottom = 24.dp),
            pagerState = pagerState,
            itemList = itemList.map { it.title },
            onAddClick = onAddTab
        )
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            pageSpacing = 32.dp,
            verticalAlignment = Alignment.Top
        ) { page ->
            Column {
                AddButton(onClick = { onAddSection(INT_ZERO, itemList[page]) })
                BuildSections(
                    modifier = Modifier
                        .wrapContentHeight()
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    sectionList = itemList[page].sections,
                    onAddSection = { position -> onAddSection(position, itemList[page]) }
                )
            }
        }
    }
}

@Composable
private fun BuildSections(
    modifier: Modifier = Modifier,
    sectionList: List<SectionModel>,
    onAddSection: (position: Int) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        sectionList.forEachIndexed { position, item ->
            Column(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                BuildSection(
                    params = BuildSectionParams(
                        sectionModel = item,
                        isEditable = false,
                        showButton = false,
                        buttonText = stringResource(R.string.button_add_section_here)
                    )
                )
            }
            AddButton(onClick = { onAddSection(position.inc()) })
        }
    }
}

@Composable
private fun AddButton(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.Horizontal = Arrangement.End,
    onClick: () -> Unit,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors,
    text: String = stringResource(R.string.button_add_section_here),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = arrangement
    ) {
        TTButtonIconSquare(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            iconRes = R.drawable.ic_save_section,
            text = text,
            colors = colors.copy(
                buttonBackground = TTTheme.colorScheme.secondaryColor,
                buttonText = White,
            ),
            onClick = onClick
        )
    }
}