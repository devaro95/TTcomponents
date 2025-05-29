package com.utils

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.components.icon.AXIcon
import com.components.styles.TopBarBackground
import com.components.text.AXBodyText18
import com.ttcomponents.app.R
import com.vro.compose.states.VROTopBarBaseState.VROTopBarState
import com.vro.constants.EMPTY_STRING

//TODO Update Color
fun topBarState(
    title: String = EMPTY_STRING,
    actionButton: @Composable (RowScope.() -> Unit)? = null,
    background: Color = TopBarBackground,
) = VROTopBarState(
    title = { AXBodyText18(text = title) },
    background = background,
    actionButton = actionButton
)

//TODO Update Color
fun topBarBackState(
    navigateBack: () -> Unit,
    title: String = EMPTY_STRING,
    actionButton: @Composable (RowScope.() -> Unit)? = null,
    background: Color = TopBarBackground,
) = VROTopBarState(
    title = { AXBodyText18(text = title) },
    navigationButton = {
        IconButton(onClick = navigateBack) {
            AXIcon(
                iconRes = R.drawable.ic_back,
                modifier = Modifier.size(16.dp),
                contentDescription = null,
                onClick = navigateBack
            )
        }
    },
    actionButton = actionButton,
    background = background
)
