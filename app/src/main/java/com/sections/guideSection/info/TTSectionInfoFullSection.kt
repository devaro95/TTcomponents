package com.sections.guideSection.info

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.info.TTInfoMessage
import com.components.info.TTInfoMessageType
import com.mock.textMock
import com.mock.titleMock
import com.utils.Section

@Composable
fun TTInfoSection() {
    Column {
        Section(
            title = "Elevated",
            text = "Elevated card info message. \ntype = TTInfoMessageType.ELEVATED"
        ) {
            TTInfoMessage(
                title = titleMock,
                message = textMock,
                type = TTInfoMessageType.ELEVATED
            )
        }
        Section(
            title = "Border",
            text = "Bordered info message. \ntype = TTInfoMessageType.BORDER"
        ) {
            TTInfoMessage(
                title = titleMock,
                message = textMock,
                type = TTInfoMessageType.BORDER
            )
        }
    }
}