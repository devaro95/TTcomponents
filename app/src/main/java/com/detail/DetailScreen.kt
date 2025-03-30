package com.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.render.RenderSections
import com.theming.TTTheme
import com.utils.topBarBackState
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

class DetailScreen : VROScreen<DetailState, DetailEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(::navigateBack)

    @Composable
    override fun ScreenContent(state: DetailState) {
        state.componentType?.let { componentType ->
            UpdateTopBar {
                topBarBackState(
                    navigateBack = ::navigateBack,
                    title = componentType.value
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
                        RenderSections(componentType)
                    }
                }
            }
        }
    }

    @Composable
    override fun ScreenPreview() {
        ScreenContent(DetailState.INITIAL)
    }

}
