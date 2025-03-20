package com.sections.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.menu.TTMenu
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemClickableData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.ttcomponents.app.R
import com.utils.Section

@Composable
fun TTMenuSection() {
    Column {
        var isChecked by remember { mutableStateOf(false) }
        Section(title = "TTMenu") {
            TTMenu(
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