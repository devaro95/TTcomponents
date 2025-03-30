package com.sections.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.components.picker.TTImagePicker
import com.mock.imageBase64Mock
import com.mock.imageMock
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTImagePickerSection() {
    Column {
        Section(title = "TTImagePicker with title, message and footer") {
            TTImagePicker(
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                onClick = {}
            )
        }
        Section(title = "TTImagePicker with aligning text") {
            TTImagePicker(
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                textAlign = TextAlign.Center,
                onClick = {}
            )
        }
        Section(title = "TTImagePicker with custom drawable image") {
            TTImagePicker(
                image = painterResource(R.drawable.ic_avatar_avocado),
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                onClick = {}
            )
        }
        Section(title = "TTImagePicker with different size") {
            TTImagePicker(
                image = painterResource(R.drawable.ic_avatar_avocado),
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                size = 100.dp,
                onClick = {},
            )
        }
        Section(title = "TTImagePicker with custom base64 image") {
            TTImagePicker(
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                customImage = imageBase64Mock,
                onClick = {}
            )
        }
        Section(title = "TTImagePicker with custom url image") {
            TTImagePicker(
                title = "Selecciona tu Avatar",
                message = "Esta imagen será la que vean todos los usuarios.",
                footerText = "O sube una foto tuya",
                customImage = imageMock,
                onClick = {}
            )
        }
    }
}
