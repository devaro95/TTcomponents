package com.sections

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.vro.constants.EMPTY_STRING

@Composable
fun Section(
    title: String,
    text: String = EMPTY_STRING,
    section: @Composable () -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(White)
                .border(1.dp, TTTheme.colorScheme.primaryColor, RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
                    .padding(top = 16.dp, bottom = if (text.isNotEmpty()) 8.dp else 16.dp)
                    .padding(end = 24.dp),
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
                    onClick = { isExpanded = !isExpanded },
                    iconRes = R.drawable.ic_back,
                    modifier = Modifier.rotate(if (isExpanded) -90f else 90f),
                    tint = TTTheme.colorScheme.primaryColor
                )
            }
            if (text.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    text = text,
                    color = TTTheme.colorScheme.primaryColor,
                    fontSize = 16.sp
                )
            }
        }
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(
                expandFrom = Alignment.Top,
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300)),
            exit = shrinkVertically(
                shrinkTowards = Alignment.Top,
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    section()
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
