package com.sections.box

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.container.TTSocialBox
import com.components.container.model.SocialModel
import com.mock.textMock
import com.mock.titleMock
import com.sections.Section

@Composable
fun TTSocialBoxSection() {
    Column {
        Section(title = "TTSocialBox full") {
            TTSocialBox(
                data = SocialModel(
                    username = "username",
                    title = titleMock,
                    description = textMock,
                    creationDate = "10/10/2025"
                ),
                onClick = {},
                onSaveClick = { _, _ -> },
                onLikeClick = { _, _ -> }
            )
        }
        Section(title = "TTSocialBox without social stats") {
            TTSocialBox(
                data = SocialModel(
                    username = "username",
                    title = titleMock,
                    description = textMock,
                    creationDate = "10/10/2025"
                ),
                onClick = {},
                onSaveClick = { _, _ -> },
                onLikeClick = { _, _ -> },
                showStats = false
            )
        }
        Section(title = "TTSocialBox without header") {
            TTSocialBox(
                data = SocialModel(
                    title = titleMock,
                    description = textMock
                ),
                onClick = {},
                onSaveClick = { _, _ -> },
                onLikeClick = { _, _ -> },
                showStats = false
            )
        }
    }
}
