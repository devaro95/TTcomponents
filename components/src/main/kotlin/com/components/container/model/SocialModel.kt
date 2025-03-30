package com.components.container.model

import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class SocialModel(
    val id: String = EMPTY_STRING,
    val username: String = EMPTY_STRING,
    val creationDate: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val userLiked: Boolean = false,
    val userSaved: Boolean = false,
    val totalLikes: Int = INT_ZERO,
    val totalSaves: Int = INT_ZERO,
)