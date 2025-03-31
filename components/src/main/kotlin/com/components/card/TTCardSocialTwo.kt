package com.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.components.button.TTButtonIconSquare
import com.components.text.AXBodyText14
import com.components.text.AXHeaderText16
import com.domain.model.GuideModel
import com.domain.model.GuideModel.ImageModel
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTGuideCard` is a composable function that creates a visually rich card to display information about a guide.
 *
 * This card is designed to present guide details in a compact and appealing way, including an image, title,
 * description, and interactive buttons for liking and saving.
 *
 * @param guide The `GuideModel` object containing the data to display in the card.
 * @param onClick Lambda that is invoked when the card is clicked. It provides the `GuideModel`
 *                of the clicked card.
 * @param onSaveClick Lambda that is invoked when the save action is clicked.
 *                    It provides:
 *                      - `isSaved`: a boolean indicating if the user has saved the guide.
 *                      - `id`: the id of the guide.
 * @param onLikeClick Lambda that is invoked when the like action is clicked.
 *                    It provides:
 *                      - `isLiked`: a boolean indicating if the user has liked the guide.
 *                      - `id`: the id of the guide.
 *
 * Example Usage:
 * @sample TTCardSocialTwoPreview
 *
 */

//TODO Check Colors
@Composable
fun TTCardSocialTwo(
    guide: GuideModel,
    onClick: (GuideModel) -> Unit,
    onSaveClick: (isSaved: Boolean, id: String) -> Unit,
    onLikeClick: (isLiked: Boolean, id: String) -> Unit,
) {
    Box(
        modifier = Modifier
            .height(230.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(guide) },
            )
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            model = guide.image.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                Column(
                    modifier = Modifier.size(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = TTTheme.colorScheme.secondaryColor
                    )
                }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TTButtonIconSquare(
                    text = guide.totalLikes.toString(),
                    iconRes = if (guide.userLiked) R.drawable.ic_like_fill
                    else R.drawable.ic_like_empty,
                    onClick = { onLikeClick(guide.userLiked, guide.id) }
                )
                TTButtonIconSquare(
                    modifier = Modifier.padding(start = 8.dp),
                    text = guide.totalSaves.toString(),
                    iconRes = if (guide.userSaved) R.drawable.ic_save_fill
                    else R.drawable.ic_save_empty,
                    onClick = { onSaveClick(guide.userSaved, guide.id) }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xD8FFFFFF))
                    .padding(16.dp)
            ) {
                AXHeaderText16(
                    text = guide.title
                )
                AXBodyText14(
                    modifier = Modifier.padding(top = 8.dp),
                    text = guide.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    minLines = 3
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
fun TTCardSocialTwoPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTCardSocialTwo(
            guide = GuideModel(
                image = ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+1"),
                title = "Amazing Places",
                description = "Discover some amazing places around the world. This is a long description",
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
        TTCardSocialTwo(
            guide = GuideModel(
                image = ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+2"),
                title = "Hidden Gems",
                description = "Uncover hidden gems in your city.This is a very very long description to show how the text is truncated with ellipsis when there are more than 3 lines.",
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
        TTCardSocialTwo(
            guide = GuideModel(
                image = ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+3"),
                title = "Another awesome Guide",
                description = "This is a very very long description to show how the text is truncated with ellipsis when there are more than 3 lines. This is a very very long description to show how the text is truncated with ellipsis when there are more than 3 lines. This is a very very long description to show how the text is truncated with ellipsis when there are more than 3 lines.",
                userLiked = true,
                totalLikes = 100,
                userSaved = false,
                totalSaves = 20,
                id = "3"
            ),
            onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
            onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
            onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTCardSocialTwo(
            guide = GuideModel(
                image = ImageModel(imageUrl = ""),
                title = "No Image",
                description = "This is a guide without image.",
                userLiked = false,
                totalLikes = 0,
                userSaved = true,
                totalSaves = 0,
                id = "4"
            ),
            onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
            onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
            onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
        )
    }
}