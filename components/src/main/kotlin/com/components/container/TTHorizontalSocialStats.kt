package com.components.container

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.container.model.HorizontalTextPosition
import com.components.container.model.SocialStatsModel
import com.theming.TTSocialStatsColors
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ONE

/**
 * `TTHorizontalSocialStats` is a composable function that displays social statistics (likes and
 * saves) in a horizontal arrangement.
 *
 * This component presents like and save information, including icons and optional text counts,
 * side-by-side. It allows customization of the text position, visibility of text labels, and
 * provides click handlers for both like and save actions.
 *
 * @param modifier Modifier to apply to the container `Row`. Use this to control layout properties
 *                 such as padding, width, and alignment.
 * @param data A `SocialStatsModel` object containing the like and save data: user's like/save
 *             status and the total counts.
 * @param colors Custom colors to use for the like and save icons and text. Defaults to
 *               `TTTheme.colorScheme.socialStatsColors`.
 * @param textPosition The position of the text labels (like/save counts) relative to their icons.
 *                     Can be `HorizontalTextPosition.Right` (default) or
 *                     `HorizontalTextPosition.Left`.
 * @param showLikeText Whether to display the text label for the like count. Defaults to `true`.
 * @param showSaveText Whether to display the text label for the save count. Defaults to `true`.
 * @param onLikeClick Lambda that is invoked when the like action (icon) is clicked.
 * @param onSaveClick Lambda that is invoked when the save action (icon) is clicked.
 *
 * Example usage:
 * @sample TTHorizontalSocialStatsPreview
 */
@Composable
fun TTHorizontalSocialStats(
    modifier: Modifier = Modifier,
    data: SocialStatsModel,
    colors: TTSocialStatsColors = TTTheme.colorScheme.socialStatsColors,
    textPosition: HorizontalTextPosition = HorizontalTextPosition.Right,
    showLikeText: Boolean = true,
    showSaveText: Boolean = true,
    onLikeClick: () -> Unit,
    onSaveClick: () -> Unit,
) {
    Row(modifier) {
        TTSocialLike(
            data = data,
            colors = colors,
            showText = showLikeText,
            textPosition = textPosition,
            onClick = onLikeClick
        )
        Spacer(modifier = Modifier.width(8.dp))
        TTSocialSave(
            data = data,
            colors = colors,
            showText = showSaveText,
            textPosition = textPosition,
            onClick = onSaveClick
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTHorizontalSocialStatsPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TTHorizontalSocialStats(
            data = SocialStatsModel(
                userLiked = true,
                totalLikes = INT_ONE
            ),
            onLikeClick = {},
            onSaveClick = {},
        )
        TTHorizontalSocialStats(
            data = SocialStatsModel(
                userSaved = true,
                totalSaves = INT_ONE
            ),
            onLikeClick = {},
            onSaveClick = {},
        )
        TTHorizontalSocialStats(
            data = SocialStatsModel(
                userSaved = true,
                totalSaves = INT_ONE
            ),
            onLikeClick = {},
            onSaveClick = {},
            textPosition = HorizontalTextPosition.Left
        )
    }
}