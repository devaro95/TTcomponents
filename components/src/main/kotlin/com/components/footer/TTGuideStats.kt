package com.components.footer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.components.icon.TTIconLike
import com.components.text.AXBodyText14
import com.theming.TTTheme
import com.ttcomponents.app.R

@Composable
fun TTGuideStats(
    modifier: Modifier = Modifier,
    userLiked: Boolean,
    onLikeClick: () -> Unit,
    totalLikes: Int,
    userSaved: Boolean,
    onSaveClick: () -> Unit,
    totalSaves: Int,
    tint: Color = TTTheme.colorScheme.primaryColor
) {
    Row(modifier) {
        TTIconLike(
            isLiked = userLiked,
            size = 18.dp,
            onClick = onLikeClick,
            tint = tint
        )
        AXBodyText14(
            modifier = Modifier.padding(start = 4.dp),
            text = totalLikes.toString(),
            color = tint
        )
        TTIcon(
            modifier = Modifier.padding(start = 8.dp),
            iconRes = if (userSaved) R.drawable.ic_save_fill
            else R.drawable.ic_save_empty,
            size = 18.dp,
            onClick = onSaveClick,
            tint = tint
        )
        AXBodyText14(
            modifier = Modifier.padding(start = 4.dp),
            text = totalSaves.toString(),
            color = tint
        )
    }
}