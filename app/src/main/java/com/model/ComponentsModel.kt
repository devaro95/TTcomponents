package com.model

import com.example.tt_components.R

object ComponentsModel {
    val allCategories = ComponentType.Category.values().map { category ->
        ComponentCategory(
            componentTypes = ComponentType.values().filter { it.category == category },
            title = when (category) {
                ComponentType.Category.Button -> "Buttons"
                ComponentType.Category.Input -> "Inputs"
                ComponentType.Category.Menu -> "Menus"
                ComponentType.Category.Card -> "Cards"
                ComponentType.Category.Section -> "Sections"
            },
            icon = when (category) {
                ComponentType.Category.Button -> R.drawable.ic_button
                ComponentType.Category.Input -> R.drawable.ic_input
                ComponentType.Category.Menu -> R.drawable.ic_menu
                ComponentType.Category.Card -> R.drawable.ic_button
                ComponentType.Category.Section -> R.drawable.ic_button
            }
        )
    }
}