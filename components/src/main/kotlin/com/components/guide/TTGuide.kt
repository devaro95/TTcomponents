package com.components.guide

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.components.button.TTButtonIconSquare
import com.components.guide.guideBuilder.BuildSection
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.indicator.TTPagerIndicator
import com.components.styles.White
import com.domain.model.SectionModel
import com.domain.model.TabModel
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.constants.INT_ZERO
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTGuide(
    itemList: List<TabModel>,
    isEditable: Boolean,
    showButton: Boolean,
    onDeleteSection: (SectionModel) -> Unit = {},
    onEditSection: (SectionModel, tab: TabModel) -> Unit = { _, _ -> },
    onAddSection: (position: Int, tab: TabModel) -> Unit = { _, _ -> },
    onSaveSection: (SectionModel, position: Int, tab: TabModel) -> Unit = { _, _, _ -> },
    onAddTab: (() -> Unit)? = null,
) {
    if (itemList.size == 1 && itemList.first().title.isEmpty()) {
        Column {
            onAddTab?.let {
                AddButton(
                    onClick = it,
                    arrangement = Arrangement.Center,
                    text = stringResource(R.string.new_tab_add)
                )
            }
            if (isEditable) {
                AddButton(
                    onClick = { onAddSection(INT_ZERO, itemList[INT_ZERO]) },
                    arrangement = Arrangement.Center
                )
            }
        }
        BuildSections(
            modifier = Modifier.padding(top = 24.dp),
            sectionList = itemList.first().sections,
            isEditable = isEditable,
            showButton = showButton,
            onDeleteSection = onDeleteSection,
            onEditSection = { onEditSection(it, itemList[INT_ZERO]) },
            onCopySection = { sectionModel, position ->
                onSaveSection(sectionModel, position, itemList[INT_ZERO])
            },
            onAddSection = { position -> onAddSection(position, itemList[INT_ZERO]) }
        )

    } else {
        val pagerState = rememberPagerState(pageCount = { itemList.size })

        TTPagerIndicator(
            modifier = Modifier.padding(vertical = 24.dp),
            pagerState = pagerState,
            itemList = itemList.map { it.title },
            onAddClick = onAddTab
        )
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
                pageSpacing = 32.dp,
                verticalAlignment = Alignment.Top,
                userScrollEnabled = itemList.size > 1
            ) { page ->
                Column {
                    if (isEditable) {
                        AddButton(
                            onClick = { onAddSection(INT_ZERO, itemList[page]) },
                            arrangement = Arrangement.Center
                        )
                    }
                    BuildSections(
                        modifier = Modifier
                            .padding(top = 16.dp)
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
                        isEditable = isEditable,
                        showButton = showButton,
                        onDeleteSection = onDeleteSection,
                        onEditSection = { onEditSection(it, itemList[page]) },
                        onCopySection = { sectionModel, position ->
                            onSaveSection(sectionModel, position, itemList[page])
                        },
                        onAddSection = { position -> onAddSection(position, itemList[page]) }
                    )
                }
            }
        }
    }
}

@Composable
private fun BuildSections(
    modifier: Modifier = Modifier,
    sectionList: List<SectionModel>,
    isEditable: Boolean,
    showButton: Boolean,
    onDeleteSection: (SectionModel) -> Unit = {},
    onEditSection: (SectionModel) -> Unit = {},
    onCopySection: (SectionModel, position: Int) -> Unit = { _, _ -> },
    onAddSection: (position: Int) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        sectionList.forEachIndexed { position, item ->
            BuildSection(
                params = BuildSectionParams(
                    sectionModel = item,
                    isEditable = isEditable,
                    showButton = showButton,
                    onDeleteSection = onDeleteSection,
                    onEditSection = onEditSection,
                    onCopySection = { onCopySection.invoke(it, position.inc()) }
                )
            )
            if (isEditable) {
                AddButton(onClick = { onAddSection(position.inc()) })
            }
        }
    }
}

@Composable
private fun AddButton(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.Horizontal = Arrangement.End,
    onClick: () -> Unit,
    text: String = stringResource(R.string.button_add_section_here),
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalArrangement = arrangement
    ) {
        TTButtonIconSquare(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            iconRes = R.drawable.ic_save_section,
            text = text,
            backgroundColor = TTTheme.colorScheme.secondaryColor,
            contentColor = White,
            onClick = onClick
        )
    }
}