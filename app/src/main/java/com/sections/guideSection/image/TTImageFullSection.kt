package com.sections.guideSection.image

import androidx.compose.runtime.Composable
import com.components.image.TTImageFull
import com.domain.model.GuideModel.ImageModel
import com.mock.imageMock
import com.mock.textMock

@Composable
fun TTImageFullSection() {
    TTImageFull(
        image = ImageModel(imageMock),
        text = textMock
    )
}