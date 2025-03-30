package com.components.picker.model

/**
 * `TTCurrencyItemData` is a data class representing a currency item in a currency picker.
 *
 * This class is designed to hold the data for each currency item in a list used within a currency
 * picker component. It contains the currency's value, name, symbol, and a unique identifier.
 *
 * @property value A `String` representing the currency code or value (e.g., "USD", "EUR", "JPY").
 *                  This could also be a numerical value.
 * @property name A `String` representing the full name of the currency (e.g., "US Dollar", "Euro",
 *                 "Japanese Yen").
 * @property symbol A `String` representing the currency symbol (e.g., "$", "€", "¥").
 * @property id An `Int` representing the unique identifier for the currency item. This ID is used
 *               internally to track and manage the item's selection state and to identify the
 *               item when an action is triggered on it.
 *
 */
data class TTCurrencyItemData(
    val value: String,
    val name: String? = null,
    val symbol: String,
    val id: Int,
)