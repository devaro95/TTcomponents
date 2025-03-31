package com.sections.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.menu.AXMenu
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableArrowData
import com.components.menu.model.AXMenuItemData.AXMenuItemClickableData
import com.components.menu.model.AXMenuItemData.AXMenuItemSwitchData
import com.sections.Section
import com.ttcomponents.app.R

@Composable
fun AXMenuSection() {
    Column {
        var isChecked by remember { mutableStateOf(false) }
        Section(title = "AXMenu") {
            AXMenu(
                items = listOf(
                    AXMenuItemClickableData(
                        icon = R.drawable.ic_guides,
                        text = "Clickable",
                        onClick = {}
                    ),
                    AXMenuItemClickableArrowData(
                        icon = R.drawable.ic_like_empty,
                        text = "Clickable Arrow",
                        onClick = {}
                    ),
                    AXMenuItemSwitchData(
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
