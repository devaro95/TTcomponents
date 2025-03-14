package com.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.detail.DetailNavigator
import com.detail.DetailScreen
import com.detail.DetailViewModel
import com.vro.compose.VROComposableActivity
import com.vro.compose.extensions.vroComposableScreen
import com.vro.compose.states.*
import org.koin.androidx.compose.koinViewModel

class MainActivity : VROComposableActivity() {

    override val startScreen = SampleScreen()

    @Composable
    override fun BottomBar(selectedItem: Int) = Unit

    override fun NavGraphBuilder.createComposableContent(
        navController: NavHostController,
        topBarState: MutableState<VROTopBarBaseState>,
        bottomBarState: MutableState<VROBottomBarBaseState>,
        snackbarState: MutableState<VROSnackBarState>,
    ) {
        vroComposableScreen(
            viewModel = { koinViewModel<SampleViewModel>() },
            navigator = SampleNavigator(this@MainActivity, navController),
            content = SampleScreen(),
            topBarState = topBarState,
            bottomBarState = bottomBarState,
            snackbarState = snackbarState
        )
        vroComposableScreen(
            viewModel = { koinViewModel<DetailViewModel>() },
            navigator = DetailNavigator(this@MainActivity, navController),
            content = DetailScreen(),
            topBarState = topBarState,
            bottomBarState = bottomBarState,
            snackbarState = snackbarState
        )
    }
}