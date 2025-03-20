package com.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.FLOAT_ZERO

@Composable
fun TTProgressLevel(
    modifier: Modifier = Modifier,
    duration: Int,
    finalProgress: Float,
    onFinish: () -> Unit = {},
) {
    var progress by remember { mutableFloatStateOf(FLOAT_ZERO) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = duration),
        label = EMPTY_STRING
    )
    LaunchedEffect(animatedProgress) {
        if (animatedProgress >= finalProgress) {
            onFinish()
        }
    }
    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = modifier
            .height(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, TTTheme.colorScheme.secondaryColor, RoundedCornerShape(10.dp)),
        color = TTTheme.colorScheme.secondaryColor,
        trackColor = TTTheme.colorScheme.background,
    )
    LaunchedEffect(LocalLifecycleOwner.current) {
        progress = finalProgress
    }
}

@VROLightMultiDevicePreview
@Composable
private fun ZQProgressLevelPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TTProgressLevel(
            duration = 4000,
            finalProgress = 1f,
            onFinish = {}
        )
    }
}