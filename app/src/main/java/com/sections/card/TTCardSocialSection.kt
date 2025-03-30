package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.card.TTCardSocial
import com.domain.model.GuideModel
import com.sections.Section

@Composable
fun TTCardSocialSection() {
    Column {
        Section(title = "TTCardSocial") {
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
        }
        Section(title = "TTCardSocial checked") {
            TTCardSocial(
                guide = GuideModel(
                    username = "Username",
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
        }
        Section(title = "TTCardSocial big height") {
            TTCardSocial(
                guide = GuideModel(
                    username = "Username",
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
}
