package com.sections.guideSection.image

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.image.TTImageCardHeader
import com.mock.imageModelMock
import com.mock.titleMock
import com.sections.Section

@Composable
fun TTImageCardHeaderSection() {
    Column {
        Section(
            title = "TTImageCardHeader",
            text = "Single image"
        ) {
            TTImageCardHeader(
                title = titleMock,
                imageList = listOf(imageModelMock),
            )

        }
        Section(
            title = "TTImageCardHeader",
            text = "Multiple images"
        ) {
            TTImageCardHeader(
                title = titleMock,
                imageList = listOf(imageModelMock, imageModelMock, imageModelMock),
            )
        }
    }
}
