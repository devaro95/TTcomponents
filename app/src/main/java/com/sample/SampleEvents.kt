package com.sample

import com.model.ComponentCategory
import com.vro.event.VROEvent

sealed class SampleEvents : VROEvent {
    data object ThemeChange : SampleEvents()
    data class List(val category: ComponentCategory) : SampleEvents()
}
