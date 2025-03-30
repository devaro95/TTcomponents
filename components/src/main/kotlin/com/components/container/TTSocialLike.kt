package com.components.container

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.container.model.HorizontalTextPosition
import com.components.container.model.SocialStatsModel
import com.components.icon.TTIconLike
import com.components.text.TTBodyText14
import com.theming.TTSocialStatsColors
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ONE

/**
 * `TTSocialLike` is a composable function that displays a social "like" button with an optional
 * like count.
 *
 * This component shows a like icon (which can be toggled between liked and unliked states) and,
 * optionally, the total number of likes. The position of the like count text relative to the icon
 * can be customized.
 *
 * @param data A `SocialStatsModel` object containing the like status (`userLiked`) and total like
 *             count (`totalLikes`).
 * @param showText Whether to display the like count text. Defaults to `true`.
 * @param textPosition The position of the like count text relative to the icon. Can be
 *                     `HorizontalTextPosition.Right` (default) or `HorizontalTextPosition.Left`.
 * @param colors Custom colors to use for the icon and text. Defaults to
 *               `TTTheme.colorScheme.socialStatsColors`.
 * @param onClick Lambda that is invoked when the like icon is clicked.
 *
 * Example usage:
 * @sample TTSocialLikePreview
 */
@Composable
fun TTSocialLike(
    data: SocialStatsModel,
    showText: Boolean = true,
    textPosition: HorizontalTextPosition = HorizontalTextPosition.Right,
    colors: TTSocialStatsColors = TTTheme.colorScheme.socialStatsColors,
    onClick: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (textPosition == HorizontalTextPosition.Right) {
            TTIconLike(
                isLiked = data.userLiked,
                size = 18.dp,
                onClick = onClick,
                tint = if (data.userLiked) colors.likeIconColor else colors.unlikeIconColor
            )
            if (showText) {
                TTBodyText14(
                    modifier = Modifier.padding(start = 4.dp),
                    text = data.totalLikes.toString(),
                    color = if (data.userLiked) colors.likeTextColor else colors.unlikeTextColor
                )
            }
        } else {
            if (showText) {
                TTBodyText14(
                    text = data.totalLikes.toString(),
                    color = if (data.userLiked) colors.likeTextColor else colors.unlikeTextColor
                )
            }
            TTIconLike(
                modifier = Modifier.padding(start = 4.dp),
                isLiked = data.userLiked,
                size = 18.dp,
                onClick = onClick,
                tint = if (data.userLiked) colors.likeIconColor else colors.unlikeIconColor
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTSocialLikePreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TTSocialLike(
            data = SocialStatsModel(),
            onClick = {},
        )
        TTSocialLike(
            data = SocialStatsModel(
                userLiked = true,
                totalLikes = INT_ONE
            ),
            onClick = {},
        )
    }
}