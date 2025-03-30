package com.list

import com.model.ComponentType
import com.vro.event.VROEvent

sealed class ListEvents : VROEvent {
    data class Detail(val componentType: ComponentType) : ListEvents()
}
