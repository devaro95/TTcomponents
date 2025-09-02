package com.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.builder.GetSections
import com.components.styles.Background
import com.utils.topBarBackState
import com.vro.compose.screen.VROScreenContent
import com.vro.compose.states.VROTopBarBaseState

class DetailScreenContent : VROScreenContent<DetailState, DetailEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(::navigateBack)

    @Composable
    override fun Content(state: DetailState) {
        LazyColumn(
            modifier = Modifier
                .background(Background)
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    GetSections(state.componentType)
                }
            }
        }
    }

    @Composable
    override fun ScreenPreview() {
        Content(DetailState.INITIAL)
    }

}