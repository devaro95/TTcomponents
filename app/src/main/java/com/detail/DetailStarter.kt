package com.detail

import com.model.ComponentType
import com.vro.navstarter.VRONavStarter

sealed class DetailStarter: VRONavStarter {
    data class Initialize(val componentType: ComponentType) : DetailStarter()
}
