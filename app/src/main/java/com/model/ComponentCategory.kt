package com.model

import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class ComponentCategory(
    val componentTypes: List<ComponentType> = emptyList(),
    val title: String = EMPTY_STRING,
    val icon: Int = INT_ZERO,
)
