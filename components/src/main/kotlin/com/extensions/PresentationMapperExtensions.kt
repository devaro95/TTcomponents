package com.extensions

import android.content.Context
import com.domain.model.AvatarModel
import com.domain.model.AvatarModel.AVOCADO
import com.domain.model.AvatarModel.BEAR
import com.domain.model.AvatarModel.CACTUS
import com.domain.model.AvatarModel.CUSTOM
import com.domain.model.AvatarModel.LAZYBONES
import com.ttcomponents.app.R
import com.vro.constants.INT_ONE
import com.vro.constants.INT_ZERO
import java.util.Currency
import java.util.Locale

fun AvatarModel.toDrawable() = when (this) {
    AVOCADO -> R.drawable.ic_avatar_avocado
    CACTUS -> R.drawable.ic_avatar_cactus
    LAZYBONES -> R.drawable.ic_avatar_lazybones
    BEAR -> R.drawable.ic_avatar_bear
    CUSTOM -> INT_ZERO
}

fun addCurrencySymbol(text: String): String {
    val symbol = Currency.getInstance(Locale.getDefault()).symbol
    return "$text $symbol"
}

fun addDiamondString(text: String, context: Context): String {
    val diamondString = context.getString(
        if (text.toInt() == INT_ONE) R.string.diamond
        else R.string.diamonds
    )
    return "$text $diamondString"
}

fun addStartString(text: String, context: Context): String {
    val startString = context.getString(
        if (text.toInt() == INT_ONE) R.string.star
        else R.string.stars
    )
    return "$text $startString"
}