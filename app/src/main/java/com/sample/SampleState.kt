package com.sample

import com.model.ComponentsModel
import com.vro.state.VROState

class SampleState(
    val components: ComponentsModel,
) : VROState {
    companion object {
        val INITIAL = SampleState(
            components = ComponentsModel
        )
    }
}