package com.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.icon.AXIcon
import com.theme.ThemeChangeEvents.ColorChange
import com.theme.ThemeChangeEvents.Confirm
import com.theme.sections.*
import com.utils.topBarBackState
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

class ThemeChangeScreen : VROScreen<ThemeChangeState, ThemeChangeEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(
            title = "Style",
            navigateBack = ::navigateBack,
            actionButton = {
                IconButton(onClick = { event(Confirm) }) {
                    AXIcon(
                        iconRes = com.example.tt_components.R.drawable.ic_save,
                        modifier = Modifier.size(16.dp),
                        contentDescription = null,
                        onClick = { event(Confirm) }
                    )
                }
            }
        )

    @Composable
    override fun ScreenContent(state: ThemeChangeState) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DefaultSection(
                state = state,
                onColorChange = { configuration, color -> event(ColorChange(configuration, color)) }
            )
            InputSection(
                state = state,
                onColorChange = { configuration, color -> event(ColorChange(configuration, color)) }
            )
            ButtonSection(
                state = state,
                onColorChange = { configuration, color -> event(ColorChange(configuration, color)) }
            )
        }
    }

    @VROLightMultiDevicePreview
    @Composable
    override fun ScreenPreview() {
        ScreenContent(ThemeChangeState.INITIAL)
    }
}
