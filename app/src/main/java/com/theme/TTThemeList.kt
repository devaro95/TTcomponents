package com.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.icon.AXIcon
import com.components.styles.White
import com.theming.TTTheme
import com.ttcomponents.app.R

@Composable
fun TTThemeList(
    title: String,
    content: @Composable () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .border(1.dp, TTTheme.colorScheme.primaryColor, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .padding(end = 24.dp)
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                text = title,
                color = TTTheme.colorScheme.primaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            AXIcon(
                onClick = { expanded = !expanded },
                iconRes = R.drawable.ic_back,
                modifier = Modifier.rotate(if (expanded) 90f else -90f),
                tint = TTTheme.colorScheme.primaryColor
            )
        }
        if (expanded) {
            Column(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    thickness = 1.dp,
                    color = TTTheme.colorScheme.primaryColor
                )
                content()
            }
        }
    }
}