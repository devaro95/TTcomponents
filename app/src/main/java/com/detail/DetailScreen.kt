package com.detail

import com.vro.compose.screen.VROScreen
import com.vro.compose.screen.VROScreenContent

class DetailScreen(
    override val screenContent: VROScreenContent<DetailState, DetailEvents> = DetailScreenContent(),
) : VROScreen<DetailState, DetailEvents>()