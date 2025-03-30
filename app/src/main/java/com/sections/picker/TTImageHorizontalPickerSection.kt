package com.sections.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.components.picker.TTImageHorizontalPicker
import com.mock.imageBase64Mock
import com.mock.imageMock
import com.ttcomponents.app.R
import com.sections.Section

@Composable
fun TTImageHorizontalPickerSection() {
    val imageList = listOf(
        painterResource(R.drawable.ic_avatar_avocado),
        painterResource(R.drawable.ic_avatar_cactus),
        painterResource(R.drawable.ic_avatar_lazybones),
        painterResource(R.drawable.ic_avatar_bear)
    )
    Column {
        Section(title = "TTImageHorizontalPicker with title, message and footer") {
            TTImageHorizontalPicker(
                images = imageList,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                footerText = "Or upload your own image!",
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker with custom base64 image") {
            TTImageHorizontalPicker(
                images = imageList,
                customImage = imageBase64Mock,
                pickerIconRes = R.drawable.ic_star,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker with custom url image") {
            TTImageHorizontalPicker(
                images = imageList,
                customImage = imageMock,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                textAlign = TextAlign.End,
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker without custom image") {
            TTImageHorizontalPicker(
                images = imageList,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                showCustomImage = false,
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker with selected item") {
            TTImageHorizontalPicker(
                images = imageList,
                initialSelectedIndex = 5,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker no title or description") {
            TTImageHorizontalPicker(
                images = imageList,
                title = "Pick your avatar",
                onImageSelected = { avatarModel -> },
                onAddImage = { },
            )
        }
        Section(title = "TTImageHorizontalPicker with text alignment") {
            TTImageHorizontalPicker(
                images = imageList,
                title = "Pick your avatar",
                message = "Select from existing avatars",
                footerText = "Or upload your own image!",
                onImageSelected = { avatarModel -> },
                onAddImage = { },
                textAlign = TextAlign.Center
            )
        }
    }
}
