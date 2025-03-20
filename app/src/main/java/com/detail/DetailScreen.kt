package com.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.builder.RenderSections
import com.theming.TTTheme
import com.utils.topBarBackState
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

class DetailScreen : VROScreen<DetailState, DetailEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(::navigateBack)

    @Composable
    override fun ScreenContent(state: DetailState) {
        UpdateTopBar {
            topBarBackState(
                navigateBack = ::navigateBack,
                title = state.componentType.value
            )
        }
        LazyColumn(
            modifier = Modifier
                .background(TTTheme.colorScheme.background)
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 30.dp)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    RenderSections(state.componentType)
                }
            }
        }

    }

    @Composable
    override fun ScreenPreview() {
        ScreenContent(DetailState.INITIAL)
    }

}