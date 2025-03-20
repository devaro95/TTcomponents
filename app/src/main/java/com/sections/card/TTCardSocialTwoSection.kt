package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.card.TTCardSocialTwo
import com.domain.model.GuideModel
import com.domain.model.GuideModel.ImageModel
import com.mock.imageMock
import com.utils.Section
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

@Composable
fun TTCardSocialTwoSection() {
    Column {
        Section(title = "TTCardSocialTwo") {
            TTCardSocialTwo(
                guide = GuideModel(
                    image = ImageModel(imageUrl = imageMock),
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
        }
        Section(title = "TTCardSocialTwo checked") {
            TTCardSocialTwo(
                guide = GuideModel(
                    image = ImageModel(imageUrl = imageMock),
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
        }
        Section(title = "TTCardSocialTwo big height") {
            TTCardSocialTwo(
                guide = GuideModel(
                    image = ImageModel(imageUrl = imageMock),
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
        }
        Section(title = "TTCardSocialTwo empty image") {
            TTCardSocialTwo(
                guide = GuideModel(
                    image = ImageModel(imageUrl = EMPTY_STRING),
                    title = "No Image",
                    description = "This is a guide without image.",
                    userLiked = false,
                    totalLikes = INT_ZERO,
                    userSaved = true,
                    totalSaves = INT_ZERO,
                    id = "4"
                ),
                onClick = { clickedGuide -> println("Clicked on guide: ${clickedGuide.title}") },
                onSaveClick = { isSaved, id -> println("Save clicked on guide $id, isSaved: $isSaved") },
                onLikeClick = { isLiked, id -> println("Like clicked on guide $id, isLiked: $isLiked") }
            )
        }
    }
}