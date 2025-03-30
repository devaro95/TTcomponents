package com.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.vro.constants.EMPTY_STRING
import com.vro.constants.LINE_JUMP
import com.vro.constants.SPACE
import java.io.ByteArrayOutputStream
import java.text.Normalizer


const val DASH = "-"

fun String.toBitmap(): Bitmap {
    val byteArray = Base64.decode(this, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
}

fun Bitmap.toBase64(): String {
    ByteArrayOutputStream().run {
        compress(Bitmap.CompressFormat.PNG, 100, this)
        return Base64.encodeToString(this.toByteArray(), Base64.DEFAULT)
    }
}

fun String.toDashedText() = "$DASH $this"

fun String.jumpOnSpace() = replace(SPACE, LINE_JUMP)

fun String.isUrl() = this.startsWith("http")