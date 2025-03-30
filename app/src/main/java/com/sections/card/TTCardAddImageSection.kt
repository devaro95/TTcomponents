package com.sections.card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.components.card.TTCardAddImage
import com.domain.model.GuideModel.ImageModel
import com.mock.imageMock
import com.sections.Section

@Composable
fun TTCardAddImageSection() {
    Column {
        Section(title = "TTCardAddImage empty") {
            TTCardAddImage(
                image = ImageModel(),
                onClick = {}
            )
        }
        Section(title = "TTCardAddImage filled") {
            TTCardAddImage(
                image = ImageModel(imageUrl = imageMock),
                onClick = {}
            )
        }
        Section(title = "TTCardAddImage height updated") {
            TTCardAddImage(
                image = ImageModel(imageUrl = imageMock),
                onClick = {},
                height = 300.dp
            )
        }
    }
}
