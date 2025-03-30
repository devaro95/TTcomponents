package com.components.card.selector.model

import java.io.Serializable

data class TTCardSelectorItem(
    val text: String,
    val value: Serializable,
) : Serializable