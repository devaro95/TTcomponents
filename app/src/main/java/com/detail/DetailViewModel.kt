package com.detail

import com.detail.DetailNavigator.DetailDestinations
import com.detail.DetailStarter.Initialize
import com.vro.navstarter.VRONavStarter
import com.vro.viewmodel.VROViewModel
import org.koin.core.annotation.Single

@Single
class DetailViewModel : VROViewModel<DetailState, DetailDestinations, DetailEvents>() {

    override val initialState = DetailState.Companion.INITIAL

    override fun onStarter(starter: VRONavStarter?) {
        when (starter) {
            is Initialize -> updateScreen { copy(componentType = starter.componentType) }
        }
    }

    override fun onEvent(event: DetailEvents) = Unit
}