package com.components.card.selector.model

import com.vro.constants.EMPTY_STRING

data class TTCardSelectorOtherItem(
    val isVisible: Boolean = false,
    val value: String = EMPTY_STRING,
    val onChange: (String) -> Unit = {},
    val placeholder: String = EMPTY_STRING,
)