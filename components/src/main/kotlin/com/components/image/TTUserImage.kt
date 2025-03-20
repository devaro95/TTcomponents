package com.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.styles.White
import  com.domain.model.AvatarModel
import com.mapper.toDrawable
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

/**
 * A composable that displays a user's profile image.
 *
 * This composable displays a user's profile picture, which can be either a default avatar
 * or a custom image. It uses a circular shape for the image and a white border.
 *
 * @param modifier Modifier to be applied to the image.
 * @param size The size of the image (both width and height).
 * @param image The URL of the user's custom image. If empty, the default avatar is used.
 * @param defaultAvatar The default avatar to use if the custom image URL is empty.
 *   If `null` and the custom image URL is empty, no image will be displayed.
 *
 * Example usage:
 * @sample TTUserImagePreview
 */
@Composable
fun TTUserImage(
    modifier: Modifier = Modifier,
    size: Dp,
    image: String,
    defaultAvatar: AvatarModel? = null,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .border(width = 2.dp, White, CircleShape)
    ) {
        if (defaultAvatar != AvatarModel.CUSTOM && defaultAvatar != null) {
            Image(
                painterResource(defaultAvatar.toDrawable()),
                contentDescription = null
            )
        } else if (image.isNotEmpty()) {
            AsyncImage(
                modifier = Modifier.size(size),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

/**
 * Example usage of the TTUserImage composable.
 */
@Preview
@Composable
private fun TTUserImagePreview() {
    TTUserImage(
        size = 64.dp,
        image = EMPTY_STRING,
        defaultAvatar = AvatarModel.AVOCADO
    )
}