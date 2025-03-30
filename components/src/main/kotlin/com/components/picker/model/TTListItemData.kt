package com.components.picker.model

/**
 * `TTListItemData` is a data class representing an item in a list picker.
 *
 * This class is designed to hold the data for each item in a list used within a picker component,
 * such as `TTListPicker`. It contains a human-readable value and a unique identifier for the item.
 *
 * @property value A `String` representing the displayable text for the list item. This is the text
 *                  that will be shown to the user in the list.
 * @property id An `Int` representing the unique identifier for the list item. This ID is used
 *               internally to track and manage the item's selection state and to identify the
 *               item when an action is triggered on it.
 */
data class TTListItemData(
    val value: String,
    val id: Int,
)