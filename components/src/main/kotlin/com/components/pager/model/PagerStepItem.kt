package com.components.pager.model

import androidx.compose.runtime.Composable

data class PagerStepItem(
    val content: @Composable () -> Unit,
)