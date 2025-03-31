package com.components.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.theming.AXTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ZERO

/**
 * `AXStepperIndicator` is a composable function that displays a step indicator, typically used
 * to visually represent progress through a series of steps or pages.
 *
 * This component renders a horizontal row of indicators, with the current step highlighted.
 *
 * @param modifier Modifier to apply to the overall container `Row`. Use this to control layout
 *                 properties such as padding, position, and width. The height is fixed at 10.dp.
 * @param items The total number of steps or items in the sequence.
 * @param currentItem The index of the currently active step. This is zero-based, so the first
 *                    item has an index of 0. Defaults to `INT_ZERO` (which is assumed to be 0).
 *
 * Example Usage:
 * @sample AXStepperIndicatorPreview
 *
 */
@Composable
fun AXStepperIndicator(
    modifier: Modifier = Modifier,
    items: Int,
    currentItem: Int = INT_ZERO,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(10.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(items) {
            Spacer(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clip(RoundedCornerShape(4.dp))
                    .border(1.dp, AXTheme.colorScheme.primaryColor, RoundedCornerShape(10.dp))
                    .alpha(
                        if (it < currentItem) 0.5f
                        else 1f
                    )
                    .background(
                        if (it <= currentItem) AXTheme.colorScheme.secondaryColor
                        else Color.Transparent
                    )
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun AXStepperIndicatorPreview() {
    AXStepperIndicator(
        items = 3,
        currentItem = 1
    )
}