package com.components.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.text.AXTextIcon
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTCardIconTextButtonPreview() {
    TTCardIconTextButton(
        iconRes = R.drawable.ic_add,
        text = stringResource(id = R.string.button_add_section),
        onClick = {}
    )
}

@Composable
fun TTCardIconTextButton(
    modifier: Modifier = Modifier,
    iconRes: Int,
    text: String,
    background: Color = Color(0xFFF6F6F6),
    onClick: () -> Unit = { },
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = background
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AXTextIcon(
                iconRes = iconRes,
                text = text
            )
        }
    }
}