package com.sections.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemClickableData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.components.menu.TTMenuRounded
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTMenuRoundedSection() {
    Column {
        var isChecked by remember { mutableStateOf(false) }
        Section(title = "TTMenu Rounded") {
            TTMenuRounded(
                title = "Title",
                items = listOf(
                    TTMenuItemClickableData(
                        icon = R.drawable.ic_guides,
                        text = "Clickable",
                        onClick = {}
                    ),
                    TTMenuItemClickableArrowData(
                        icon = R.drawable.ic_like_empty,
                        text = "Clickable Arrow",
                        onClick = {}
                    ),
                    TTMenuItemSwitchData(
                        icon = R.drawable.ic_diamond,
                        text = "Switch",
                        isChecked = isChecked,
                        onChange = { isChecked = !isChecked }
                    )
                )
            )
        }
    }
}
