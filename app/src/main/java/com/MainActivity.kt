package com

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.components.styles.TTTheme
import com.detail.*
import com.list.*
import com.sample.*
import com.theme.ThemeChangeNavigator
import com.theme.ThemeChangeScreen
import com.theme.ThemeChangeViewModel
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableTheme
import com.vro.compose.extensions.vroComposableScreen
import com.vro.compose.states.*
import org.koin.androidx.compose.koinViewModel

class MainActivity : VROComposableActivity() {

    override val startScreen = SampleScreen()

    override val theme: VROComposableTheme = TTTheme

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
        vroComposableScreen(
            viewModel = { koinViewModel<ThemeChangeViewModel>() },
            navigator = ThemeChangeNavigator(this@MainActivity, navController),
            content = ThemeChangeScreen(),
            topBarState = topBarState,
            bottomBarState = bottomBarState,
            snackbarState = snackbarState
        )
        vroComposableScreen(
            viewModel = { koinViewModel<ListViewModel>() },
            navigator = ListNavigator(this@MainActivity, navController),
            content = ListScreen(),
            topBarState = topBarState,
            bottomBarState = bottomBarState,
            snackbarState = snackbarState
        )
    }
}
