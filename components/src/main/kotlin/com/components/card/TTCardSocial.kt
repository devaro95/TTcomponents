package com.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.footer.TTGuideStats
import com.components.styles.*
import com.components.text.AXBodyText
import com.components.text.AXHeaderText18
import com.domain.model.GuideModel
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardGuide` is a composable function that creates a card to display information about a guide.
 *
 * This card provides a structured view of guide details, including the username, creation date,
 * title, description, and interactive statistics like likes and saves.
 *
 * @param modifier Modifier to apply to the outer `TTCardElevated` of the card.
 *                 Use this to control layout properties like padding, size, and alignment.
 * @param guide The `GuideModel` object containing the data to display in the card.
 * @param onClick Lambda that is invoked when the card is clicked. It provides the `GuideModel`
 *                of the clicked card.
 * @param onSaveClick Lambda that is invoked when the save action is clicked.
 *                    It provides:
 *                      - `isLiked`: a boolean if the user has saved the guide.
 *                      - `id`: the id of the guide.
 * @param onLikeClick Lambda that is invoked when the like action is clicked.
 *                    It provides:
 *                      - `isLiked`: a boolean if the user has liked the guide.
 *                      - `id`: the id of the guide.
 *
 * Example Usage:
 * @sample TTCardSocialPreview
 *
 */

//TODO Check Colors
@Composable
fun TTCardSocial(
    modifier: Modifier = Modifier,
    guide: GuideModel,
    onClick: (guide: GuideModel) -> Unit,
    onSaveClick: (isLiked: Boolean, id: String) -> Unit,
    onLikeClick: (isLiked: Boolean, id: String) -> Unit,
) {
    TTCardElevated(
        modifier = modifier.border(1.dp, CardBorder, RoundedCornerShape(10.dp)),
        onClick = { onClick(guide) },
    ) {
        Column {
            Column(
                modifier = Modifier
                    .background(CardBackground)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = guide.username,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = GuideCardHeader
                    )
                    Text(
                        text = guide.creationDate,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = GuideCardHeader
                    )
                }
                AXHeaderText18(
                    modifier = Modifier.padding(top = 8.dp),
                    text = guide.title
                )
                AXBodyText(
                    modifier = Modifier.padding(top = 4.dp),
                    text = guide.description,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TTGuideStats(
                        userLiked = guide.userLiked,
                        onLikeClick = { onLikeClick(guide.userLiked, guide.id) },
                        totalLikes = guide.totalLikes,
                        userSaved = guide.userSaved,
                        onSaveClick = { onSaveClick.invoke(guide.userSaved, guide.id) },
                        totalSaves = guide.totalSaves,
                    )
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardSocialPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTCardSocial(
            guide = GuideModel(
                username = "Username",
                creationDate = "2023-10-26",
                title = "Amazing Places",
                description = "Discover some amazing places around the world.",
                userLiked = false,
                totalLikes = 10,
                userSaved = false,
                totalSaves = 2,
                id = "1"
            ),
            onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
            onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
            onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTCardSocial(
            guide = GuideModel(
                username = "exampleUser2",
                creationDate = "2023-10-27",
                title = "Hidden Gems",
                description = "Uncover hidden gems in your city.",
                userLiked = true,
                totalLikes = 25,
                userSaved = true,
                totalSaves = 15,
                id = "2"
            ),
            onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
            onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
            onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTCardSocial(
            guide = GuideModel(
                username = "exampleUser3",
                creationDate = "2023-11-27",
                title = "Long description guide",
                description = "This is a very very long description to show how the text is truncated with ellipsis when there are more than 6 lines. This is a very very long description to show how the text is truncated with ellipsis when there are more than 6 lines. This is a very very long description to show how the text is truncated with ellipsis when there are more than 6 lines.",
                userLiked = true,
                totalLikes = 25,
                userSaved = false,
                totalSaves = 15,
                id = "3"
            ),
            onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
            onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
            onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
        )
    }
}