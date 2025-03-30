package com.sections.guideSection.image

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.components.image.TTUserImage
import com.domain.model.AvatarModel
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTUserImageSection() {
    Column {
        Section(
            title = "TTUserImage",
            text = "TTUserImage example"
        ) {
            TTUserImage(
                size = 64.dp,
                image = EMPTY_STRING,
                defaultAvatar = AvatarModel.AVOCADO
            )
        }
    }
}
