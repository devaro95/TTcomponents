package com.model

object ComponentsModel {
    val allCategories = ComponentType.Category.entries.map { category ->
        ComponentCategory(
            componentTypes = ComponentType.entries.filter { it.category == category },
            title = category.title,
            icon = category.icon
        )
    }
}
