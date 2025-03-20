package com.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.theming.TTColors
import com.theming.TTTheme
import com.utils.topBarBackState
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

class ThemeChangeScreen : VROScreen<ThemeChangeState, ThemeChangeEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(
            navigateBack = ::navigateBack,
            title = "Theme Change"
        )

    @Composable
    override fun ScreenContent(state: ThemeChangeState) {
        Column(modifier = Modifier.fillMaxSize().background(TTTheme.colorScheme.background)) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(50.dp)
                    .clickable {
                        TTTheme.setColors(
                            TTColors.defaultColors.copy(
                                primaryColor = Color.Blue
                            )
                        )
                    }
            )
        }
    }

    @VROLightMultiDevicePreview
    @Composable
    override fun ScreenPreview() {
        ScreenContent(ThemeChangeState.INITIAL)
    }
}