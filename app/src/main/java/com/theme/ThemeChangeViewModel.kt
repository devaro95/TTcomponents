package com.theme

import com.theme.ThemeChangeNavigator.ThemeChangeDestinations
import com.vro.compose.VROComposableViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ThemeChangeViewModel : VROComposableViewModel<ThemeChangeState, ThemeChangeDestinations, ThemeChangeEvents>() {

    override val initialState = ThemeChangeState.INITIAL

    override fun onEvent(event: ThemeChangeEvents) {

    }

}