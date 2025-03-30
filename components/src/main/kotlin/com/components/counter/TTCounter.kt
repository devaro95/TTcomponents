package com.components.counter

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.components.styles.SecondaryBackground
import com.components.text.TTHeaderText14
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ONE

/**
 * `TTCounter` is a composable function that creates a counter with increment and decrement buttons.
 *
 * This component displays a numerical value along with buttons to increase and decrease it.
 *
 * @param modifier Modifier to apply to the counter's outer `Row`. Use this to control layout
 *                 properties such as position, size, and padding.
 * @param value The current integer value of the counter.
 * @param onAddClick Lambda that is invoked when the "add" button is clicked. It receives the
 *                   current `value` as a parameter.
 * @param onSubtract Lambda that is invoked when the "subtract" button is clicked. It receives the
 *                    current `value` as a parameter.
 *
 * Example Usage:
 * @sample TTCounterPreview
 */
@Composable
fun TTCounter(
    modifier: Modifier = Modifier,
    value: Int,
    onAddClick: (Int) -> Unit,
    onSubtract: (Int) -> Unit,
) {
    Row(
        modifier = modifier.height(30.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(TTTheme.colorScheme.secondaryColor)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onSubtract(value) },
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TTIcon(
                modifier = Modifier.padding(6.dp),
                iconRes = R.drawable.ic_less,
                size = 20.dp,
                tint = Color.White,
                onClick = { onSubtract(value) }
            )
        }
        TTHeaderText14(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(SecondaryBackground)
                .border(1.dp, TTTheme.colorScheme.primaryColor, RoundedCornerShape(8.dp))
                .padding(horizontal = 4.dp)
                .padding(top = 7.dp)
                .fillMaxHeight()
                .width(50.dp),
            text = value.toString(),
            textAlign = TextAlign.Center
        )
        Column(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(TTTheme.colorScheme.secondaryColor)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onAddClick(value) },
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TTIcon(
                modifier = Modifier.padding(6.dp),
                iconRes = R.drawable.ic_plus,
                size = 20.dp,
                tint = Color.White,
                onClick = { onAddClick(value) }
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCounterPreview() {
    TTCounter(
        value = INT_ONE,
        onAddClick = {},
        onSubtract = {}
    )
}