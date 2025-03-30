package com.components.container.model

import com.vro.constants.INT_ZERO

data class SocialStatsModel(
    val userLiked: Boolean = false,
    val totalLikes: Int = INT_ZERO,
    val userSaved: Boolean = false,
    val totalSaves: Int = INT_ZERO,
)
