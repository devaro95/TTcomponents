package com.list

import com.model.ComponentCategory
import com.vro.state.VROState

data class ListState(
    val category: ComponentCategory,
) : VROState {
    companion object {
        val INITIAL = ListState(
            category = ComponentCategory()
        )
    }
}