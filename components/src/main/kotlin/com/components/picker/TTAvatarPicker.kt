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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.icon.TTIcon
import com.components.text.TTBodyText
import com.components.text.TTHeaderText24
import com.domain.model.AvatarModel
import com.extensions.toBitmap
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTImagePicker(
    modifier: Modifier = Modifier,
    imageUrl: String = EMPTY_STRING,
    imageBase64: String,
    defaultAvatar: AvatarModel? = null,
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
        TTHeaderText24(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = textAlign
        )
        TTBodyText(
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
                if (imageBase64.isNotEmpty()) {
                    Image(
                        bitmap = imageBase64.toBitmap().asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else if (imageUrl.isNotEmpty()) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.align(Alignment.Center)) {
                    TTIcon(
                        iconRes = R.drawable.ic_plus,
                        size = 24.dp,
                        onClick = onClick
                    )
                }
            }
        }
        if (footerText.isNotEmpty()) {
            TTBodyText(
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
fun TTImagePickerPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        TTImagePicker(
            imageBase64 = EMPTY_STRING,
            title = "Selecciona tu Avatar",
            message = "Esta imagen será la que vean todos los usuarios.",
            footerText = "O sube una foto tuya",
            defaultAvatar = AvatarModel.AVOCADO
        )
    }
}