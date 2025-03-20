package com.sample

import androidx.navigation.NavController
import com.model.ComponentCategory
import com.list.ListScreen
import com.list.ListStarter
import com.sample.SampleNavigator.SampleDestinations
import com.sample.SampleNavigator.SampleDestinations.ListDestination
import com.sample.SampleNavigator.SampleDestinations.ThemeChangeDestination
import com.theme.ThemeChangeScreen
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableNavigator
import com.vro.navigation.VRODestination

class SampleNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<SampleDestinations>(activity, navController) {

    override fun navigate(destination: SampleDestinations) {
        when (destination) {
            ThemeChangeDestination -> navigateToScreen(
                screen = ThemeChangeScreen(),
            )

            is ListDestination -> navigateToScreen(
                screen = ListScreen(),
                starter = ListStarter.Initialize(destination.componentCategory)
            )
        }
    }

    sealed class SampleDestinations : VRODestination() {
        data object ThemeChangeDestination : SampleDestinations()
        data class ListDestination(val componentCategory: ComponentCategory) : SampleDestinations()
    }
}