package com.sample

import com.model.ComponentCategory
import com.sample.SampleEvents.ThemeChange
import com.sample.SampleNavigator.SampleDestinations
import com.sample.SampleNavigator.SampleDestinations.ListDestination
import com.sample.SampleNavigator.SampleDestinations.ThemeChangeDestination
import com.vro.compose.VROComposableViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SampleViewModel : VROComposableViewModel<SampleState, SampleDestinations, SampleEvents>() {

    override val initialState = SampleState.INITIAL

    override fun onEvent(event: SampleEvents) {
        when (event) {
            is ThemeChange -> onThemeChange()
            is SampleEvents.List -> onListClick(event.category)
        }
    }

    private fun onThemeChange() {
        navigate(ThemeChangeDestination)
    }

    private fun onListClick(category: ComponentCategory) {
        navigate(ListDestination(category))
    }
}
