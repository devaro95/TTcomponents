package com.list

import androidx.navigation.NavController
import com.model.ComponentType
import com.detail.DetailScreen
import com.detail.DetailStarter
import com.list.ListNavigator.ListDestinations
import com.list.ListNavigator.ListDestinations.DetailDestination
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableNavigator
import com.vro.navigation.VRODestination

class ListNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<ListDestinations>(activity, navController) {

    override fun navigate(destination: ListDestinations) {
        when (destination) {
            is DetailDestination -> navigateToScreen(
                screen = DetailScreen(),
                starter = DetailStarter.Initialize(destination.componentType)
            )

        }
    }

    sealed class ListDestinations : VRODestination() {
        data class DetailDestination(val componentType: ComponentType) : ListDestinations()
    }
}