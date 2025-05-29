package com.components.picker

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.icon.AXIcon
import com.components.text.AXBodyText
import com.components.text.AXHeaderText24
import com.extensions.isUrl
import com.extensions.toBitmap
import com.mock.imageBase64Mock
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

/**
 * `TTImagePicker` is a composable function that creates an image picker component.
 *
 * This component allows the user to select an image, either from a predefined set,
 * by providing a custom image (as a Base64 string or an URL), or by clicking an "add" icon.
 * It displays a circular image area, along with a title, message, and optional footer text.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the image picker.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param image Optional `Painter` representing a predefined image to display. If provided,
 *              this image will be shown as the default.
 * @param customImage Optional Base64 string or an URL of a custom image. If provided and
 *                    `image` is `null`, this image will be shown.
 * @param title The title text to be displayed above the image area.
 * @param message The message text to be displayed below the title.
 * @param footerText Optional text to be displayed below the image area. Defaults to `EMPTY_STRING`.
 * @param size The size (width and height) of the circular image area. Defaults to `180.dp`.
 * @param textAlign Optional text alignment for the title, message, and footer text. If `null`,
 *                  the default text alignment is used.
 * @param onClick Lambda that is invoked when the image area (or the "add" icon) is clicked.
 *
 * Example Usage:
 * @sample TTImagePickerPreview
 */
@Composable
fun TTImagePicker(
    modifier: Modifier = Modifier,
    image: Painter? = null,
    customImage: String? = null,
    title: String,
    message: String,
    footerText: String = EMPTY_STRING,
    size: Dp = 180.dp,
    textAlign: TextAlign? = null,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        AXHeaderText24(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = textAlign
        )
        AXBodyText(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            text = message,
            textAlign = textAlign
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .border(2.dp, TTTheme.colorScheme.primaryColor, CircleShape)
                    .clip(CircleShape)
                    .size(size)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onClick,
                    )
            ) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                    when {
                        !customImage.isNullOrEmpty() && customImage.isUrl() -> {
                            AsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                model = customImage,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }

                        !customImage.isNullOrEmpty() && !customImage.isUrl() -> {
                            Image(
                                modifier = Modifier.fillMaxSize(),
                                bitmap = customImage.toBitmap().asImageBitmap(),
                                contentDescription = EMPTY_STRING,
                                contentScale = ContentScale.Crop
                            )
                        }

                        else -> {
                            image?.let {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = it,
                                    contentDescription = EMPTY_STRING,
                                    contentScale = ContentScale.Crop
                                )
                            } ?: run {
                                AXIcon(
                                    iconRes = R.drawable.ic_plus,
                                    size = 24.dp,
                                    onClick = onClick
                                )
                            }
                        }
                    }
                }
            }
        }
        if (footerText.isNotEmpty()) {
            AXBodyText(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                text = footerText,
                textAlign = textAlign
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTImagePickerPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        TTImagePicker(
            title = "Selecciona tu Avatar",
            message = "Esta imagen será la que vean todos los usuarios.",
            footerText = "O sube una foto tuya",
            onClick = {}
        )
        TTImagePicker(
            image = painterResource(R.drawable.ic_avatar_avocado),
            title = "Selecciona tu Avatar",
            message = "Esta imagen será la que vean todos los usuarios.",
            footerText = "O sube una foto tuya",
            onClick = {}
        )
        TTImagePicker(
            image = painterResource(R.drawable.ic_avatar_avocado),
            title = "Selecciona tu Avatar",
            message = "Esta imagen será la que vean todos los usuarios.",
            footerText = "O sube una foto tuya",
            customImage = imageBase64Mock,
            onClick = {}
        )
        TTImagePicker(
            image = painterResource(R.drawable.ic_avatar_avocado),
            title = "Selecciona tu Avatar",
            message = "Esta imagen será la que vean todos los usuarios.",
            footerText = "O sube una foto tuya",
            customImage = imageBase64Mock,
            textAlign = TextAlign.Center,
            onClick = {}
        )
    }
}