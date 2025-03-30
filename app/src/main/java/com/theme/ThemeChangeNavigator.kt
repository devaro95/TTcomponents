package com.theme

import androidx.navigation.NavController
import com.model.ColorConfiguration
import com.theme.ThemeChangeNavigator.ThemeChangeDestinations
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableNavigator
import com.vro.navigation.VRODestination

class ThemeChangeNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<ThemeChangeDestinations>(activity, navController) {

    override fun navigate(destination: ThemeChangeDestinations) {

    }

    sealed class ThemeChangeDestinations : VRODestination() {
        data class StyleDestination(val colorConfiguration: ColorConfiguration) : ThemeChangeDestinations()
    }
}
