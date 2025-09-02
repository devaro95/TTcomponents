package com.sample

import com.vro.compose.screen.VROScreen
import com.vro.compose.screen.VROScreenContent

class SampleScreen(
    override val screenContent: VROScreenContent<SampleState, SampleEvents>? = SampleScreenContent(),
) : VROScreen<SampleState, SampleEvents>()