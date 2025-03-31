package com.components.container

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.container.model.SocialStatsModel
import com.components.container.model.HorizontalTextPosition
import com.components.icon.TTIcon
import com.components.text.AXBodyText14
import com.theming.TTSocialStatsColors
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ONE

/**
 * `TTSocialSave` is a composable function that displays a social "save" button with an optional
 * save count.
 *
 * This component shows a save icon (which can visually indicate saved or unsaved state) and,
 * optionally, the total number of saves. The position of the save count text relative to the icon
 * can be customized.
 *
 * @param data A `SocialStatsModel` object containing the save status (`userSaved`) and total save
 *             count (`totalSaves`).
 * @param showText Whether to display the save count text. Defaults to `true`.
 * @param textPosition The position of the save count text relative to the icon. Can be
 *                     `HorizontalTextPosition.Right` (default) or `HorizontalTextPosition.Left`.
 * @param colors Custom colors to use for the icon and text. Defaults to
 *               `TTTheme.colorScheme.socialStatsColors`.
 * @param onClick Lambda that is invoked when the save icon is clicked.
 *
 * Example usage:
 * @sample TTSocialSavePreview
 */
@Composable
fun TTSocialSave(
    data: SocialStatsModel,
    showText: Boolean = true,
    textPosition: HorizontalTextPosition = HorizontalTextPosition.Right,
    colors: TTSocialStatsColors = TTTheme.colorScheme.socialStatsColors,
    onClick: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (textPosition == HorizontalTextPosition.Right) {
            TTIcon(
                iconRes = if (data.userSaved) R.drawable.ic_save_fill
                else R.drawable.ic_save_empty,
                size = 18.dp,
                onClick = onClick,
                tint = if (data.userSaved) colors.saveIconColor else colors.unsaveIconColor
            )
            if (showText) {
                AXBodyText14(
                    modifier = Modifier.padding(start = 4.dp),
                    text = data.totalSaves.toString(),
                    color = if (data.userSaved) colors.likeTextColor else colors.unlikeTextColor
                )
            }
        } else {
            if (showText) {
                AXBodyText14(

                    text = data.totalSaves.toString(),
                    color = if (data.userSaved) colors.likeTextColor else colors.unlikeTextColor
                )
            }
            TTIcon(
                modifier = Modifier.padding(start = 4.dp),
                iconRes = if (data.userSaved) R.drawable.ic_save_fill
                else R.drawable.ic_save_empty,
                size = 18.dp,
                onClick = onClick,
                tint = if (data.userSaved) colors.saveIconColor else colors.unsaveIconColor
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTSocialSavePreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TTSocialSave(
            data = SocialStatsModel(),
            onClick = {},
        )
        TTSocialSave(
            data = SocialStatsModel(
                userLiked = true,
                totalLikes = INT_ONE
            ),
            onClick = {},
        )
    }
}