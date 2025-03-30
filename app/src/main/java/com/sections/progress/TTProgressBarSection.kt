package com.sections.progress

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.progress.TTProgressBar
import com.sections.Section

@Composable
fun TTProgressBarSection() {
    Column {
        Section(title = "TTCurrencyPicker empty") {
            TTProgressBar(
                duration = 4000,
                progress = 0f
            )
        }
        Section(title = "TTImagePicker custom progress") {
            TTProgressBar(
                duration = 1000,
                progress = 0.5f
            )
        }
        Section(title = "TTImagePicker full progress") {
            TTProgressBar(
                duration = 1000,
                progress = 1f
            )
        }
    }
}
