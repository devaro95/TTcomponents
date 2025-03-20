package com.components.card

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.icon.TTIcon
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ZERO

@Composable
fun TTCardFilter(
    onClick: () -> Unit,
    filters: Int = INT_ZERO,
) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = TTTheme.colorScheme.secondaryColor,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TTIcon(
            iconRes = R.drawable.ic_filter,
            size = 14.dp,
            tint = TTTheme.colorScheme.secondaryColor,
            onClick = onClick
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = stringResource(R.string.filter),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            color = TTTheme.colorScheme.secondaryColor
        )
        if (filters > INT_ZERO) {
            VerticalDivider(
                modifier = Modifier
                    .height(14.dp)
                    .padding(horizontal = 8.dp),
                thickness = 1.dp,
                color = TTTheme.colorScheme.secondaryColor
            )
            Text(
                text = filters.toString(),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 14.sp,
                color = TTTheme.colorScheme.secondaryColor
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardFilterPreview() {
    Column {
        TTCardFilter(
            onClick = {},
            filters = 0
        )
        TTCardFilter(
            onClick = {},
            filters = 3
        )
    }
}