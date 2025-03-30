package com.sections.pager

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.pager.TTPager
import com.components.pager.model.PagerStepItem
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.sections.Section

@Composable
fun TTPagerSection() {
    val itemList = listOf(
        PagerStepItem(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TTHeaderText18(text = "This is the first Page")
                    TTBodyText(text = "This is an example of pager content")
                }
            }
        ),
        PagerStepItem(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TTHeaderText18(text = "This is the second Page")
                    TTBodyText(text = "This is an example of pager content")
                }
            }
        ),
    )
    Column {
        Section(title = "TTPager") {
            TTPager(
                stepList = itemList
            )
        }
    }
}
