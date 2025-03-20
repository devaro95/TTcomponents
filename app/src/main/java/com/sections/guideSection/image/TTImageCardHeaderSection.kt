package com.sections.guideSection.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.image.TTImageCardHeader
import com.mock.imageModelMock
import com.mock.titleMock
import com.utils.Section

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