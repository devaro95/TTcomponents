package com.components.indicator

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.theming.AXTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.FLOAT_ZERO

/**
 * `AXProgressIndicator` is a composable function that creates a custom linear progress bar.
 *
 * This component displays a linear progress bar that animates from 0 to `finalProgress` over
 * a specified duration. It also provides a callback for when the progress reaches its final value.
 *
 * @param modifier Modifier to apply to the progress bar. Use this to control layout properties, such as
 *                 padding, size, and alignment.
 * @param duration The duration of the animation in milliseconds.
 * @param progress The final progress value (between 0.0 and 1.0) that the progress bar will animate to.
 * @param onFinish Lambda that is invoked when the progress bar reaches the `finalProgress` value.
 *                 Defaults to an empty lambda.
 *
 * Example Usage:
 * @sample AXProgressIndicatorPreview
 *
 */
@Composable
fun AXProgressIndicator(
    modifier: Modifier = Modifier,
    duration: Int,
    progress: Float,
    onFinish: () -> Unit = {},
) {
    val isPreview = LocalInspectionMode.current
    var finalProgress by remember { mutableFloatStateOf(FLOAT_ZERO) }
    val animatedProgress by animateFloatAsState(
        targetValue = if (isPreview) progress else finalProgress,
        animationSpec = if (isPreview) snap() else tween(durationMillis = duration),
        label = EMPTY_STRING
    )
    LaunchedEffect(animatedProgress) {
        if (animatedProgress >= progress) {
            onFinish()
        }
    }
    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = modifier
            .height(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, AXTheme.colorScheme.secondaryColor, RoundedCornerShape(10.dp)),
        color = AXTheme.colorScheme.secondaryColor,
        trackColor = AXTheme.colorScheme.background,
    )
    LaunchedEffect(LocalLifecycleOwner.current) {
        finalProgress = progress
    }
}

@Composable
@VROLightMultiDevicePreview
fun AXProgressIndicatorPreview() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        AXProgressIndicator(
            duration = 4000,
            progress = 0f
        )

        Spacer(modifier = Modifier.height(16.dp))

        AXProgressIndicator(
            duration = 1000,
            progress = 0.5f
        )
        Spacer(modifier = Modifier.height(16.dp))

        AXProgressIndicator(
            duration = 1000,
            progress = 0.75f
        )

        Spacer(modifier = Modifier.height(16.dp))
        AXProgressIndicator(
            duration = 1000,
            progress = 1f
        )
    }
}