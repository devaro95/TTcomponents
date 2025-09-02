package com.sample

import androidx.navigation.NavController
import com.ComponentType
import com.detail.DetailScreen
import com.detail.DetailStarter
import com.sample.SampleNavigator.SampleDestinations
import com.vro.compose.VROComposableActivity
import com.vro.compose.navigator.VROComposableNavigator
import com.vro.navigation.VRODestination

class SampleNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<SampleDestinations>(activity, navController) {

    override fun navigate(destination: SampleDestinations) {
        when (destination) {
            is SampleDestinations.DetailDestination -> navigateToScreen(
                screen = DetailScreen(),
                starter = DetailStarter.Initialize(destination.componentType)
            )
        }
    }

    sealed class SampleDestinations : VRODestination() {
        data class DetailDestination(val componentType: ComponentType) : SampleDestinations()
    }
}