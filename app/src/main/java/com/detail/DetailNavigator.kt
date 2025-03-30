package com.detail

import androidx.navigation.NavController
import com.detail.DetailNavigator.DetailDestinations
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableNavigator
import com.vro.navigation.VRODestination

class DetailNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<DetailDestinations>(activity, navController) {

    override fun navigate(destination: DetailDestinations) = Unit

    sealed class DetailDestinations : VRODestination()
}
