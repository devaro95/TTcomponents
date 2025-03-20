package com.list

import com.model.ComponentCategory
import com.vro.navstarter.VRONavStarter

sealed class ListStarter: VRONavStarter {
    data class Initialize(val componentCategory: ComponentCategory) : ListStarter()
}