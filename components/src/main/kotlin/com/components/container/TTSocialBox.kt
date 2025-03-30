package com.components.container

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.container.model.SocialModel
import com.components.footer.TTGuideStats
import com.components.styles.GuideCardHeader
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.theming.TTTheme
import com.theming.colors.TTCardColors
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTSocialBox` is a composable function that creates a card displaying social content.
 *
 * This component displays a card with information about a social post or item, including
 * the username, creation date, title, description, and optionally, statistics like likes and saves.
 * The card is clickable and can trigger actions for liking, saving, and general interaction.
 *
 * @param modifier Modifier to apply to the card. Use this to control layout properties, such as
 *                 padding, size, and alignment.
 * @param data A `SocialModel` object containing the data for the social item to be displayed.
 * @param shape The shape of the card. Defaults to `RectangleShape`.
 * @param border An optional `BorderStroke` to apply to the card. If `null`, no border is applied.
 * @param showStats Whether to display the statistics (likes and saves) for the social item.
 *                  Defaults to `true`.
 * @param colors Custom colors to be used for the card. Defaults to `TTTheme.colorScheme.cardColors`.
 * @param onClick Lambda that is invoked when the card is clicked. It provides the `SocialModel`
 *                data of the clicked item.
 * @param onSaveClick An optional lambda that is invoked when the save action is clicked. It provides
 *                    a boolean indicating whether the item is saved and the item's ID. If `null`,
 *                    the save action is not displayed.
 * @param onLikeClick An optional lambda that is invoked when the like action is clicked. It provides
 *                    a boolean indicating whether the item is liked and the item's ID. If `null`,
 *                    the like action is not displayed.
 *
 * Example usage:
 * @sample TTSocialBoxPreview
 */
@Composable
fun TTSocialBox(
    modifier: Modifier = Modifier,
    data: SocialModel,
    shape: Shape = RectangleShape,
    border: BorderStroke? = null,
    showStats: Boolean = true,
    colors: TTCardColors = TTTheme.colorScheme.cardColors,
    onClick: (data: SocialModel) -> Unit,
    onSaveClick: ((isLiked: Boolean, id: String) -> Unit)? = null,
    onLikeClick: ((isLiked: Boolean, id: String) -> Unit)? = null,
) {
    ElevatedCard(
        modifier = modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(data) })
            .apply {
                border?.let { border(it.width, it.brush, shape) } ?: this
            },
        colors = CardDefaults.elevatedCardColors(
            containerColor = colors.containerColor,
            contentColor = colors.contentColor,
            disabledContainerColor = colors.disabledContainerColor,
            disabledContentColor = colors.disabledContentColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clip(shape)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (data.username.isNotEmpty()) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = data.username,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = GuideCardHeader
                    )
                }
                if (data.creationDate.isNotEmpty()) {
                    Text(
                        text = data.creationDate,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = GuideCardHeader
                    )
                }
            }
            TTHeaderText18(
                modifier = Modifier.padding(top = 8.dp),
                text = data.title
            )
            TTBodyText(
                modifier = Modifier.padding(top = 4.dp),
                text = data.description,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
            if (showStats) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TTGuideStats(
                        userLiked = data.userLiked,
                        onLikeClick = { onLikeClick?.invoke(data.userLiked, data.id) },
                        totalLikes = data.totalLikes,
                        userSaved = data.userSaved,
                        onSaveClick = { onSaveClick?.invoke(data.userSaved, data.id) },
                        totalSaves = data.totalSaves,
                    )
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTSocialBoxPreview() {
    TTSocialBox(
        data = SocialModel(
            username = "devaro95",
            title = "Guía por España",
            description = "Descubre los lugares más fascinantes en la España escondida."
        ),
        onClick = {},
        onSaveClick = { _, _ -> },
        onLikeClick = { _, _ -> }
    )
}