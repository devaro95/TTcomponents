package com.sample

import com.ComponentType
import com.sample.SampleEvents.Detail
import com.sample.SampleNavigator.SampleDestinations
import com.sample.SampleNavigator.SampleDestinations.DetailDestination
import com.vro.viewmodel.VROViewModel
import org.koin.core.annotation.Single

@Single
class SampleViewModel : VROViewModel<SampleState, SampleDestinations, SampleEvents>() {

    override val initialState = SampleState.INITIAL

    override fun onEvent(event: SampleEvents) {
        when (event) {
            is Detail -> onDetailClick(event.componentType)
        }
    }

    private fun onDetailClick(componentType: ComponentType) {
        navigate(DetailDestination(componentType))
    }
}