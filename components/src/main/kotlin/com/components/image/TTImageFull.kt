package com.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.text.TTBodyText
import com.domain.model.GuideModel.ImageModel
import com.extensions.toBitmap
import com.mock.imageModelMock
import com.mock.textMock
import com.vro.constants.EMPTY_STRING

/**
 * A composable that displays an image with optional descriptive text below.
 *
 * This composable displays either a remote image loaded using [AsyncImage] or a
 * local image loaded from a Base64 string. It also supports displaying a
 * descriptive text below the image.
 *
 * @param image The [ImageModel] containing either the URL of the image or its Base64
 *   representation.
 * @param text The text to display below the image. Defaults to an empty string.
 * @param modifier Modifier to be applied to the image and text.
 *
 * Example usage:
 * @sample TTImageFullPreview
 */
@Composable
fun TTImageFull(
    modifier: Modifier = Modifier,
    image: ImageModel,
    text: String = EMPTY_STRING,
) {
    Column(modifier = modifier) {
        if (image.imageUrl.isEmpty()) {
            Image(
                bitmap = image.imageBase64.toBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                model = image.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        TTBodyText(
            text = text,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

/**
 * Example usage of the TTImageFull composable.
 */
@Preview
@Composable
fun TTImageFullPreview() {
    TTImageFull(
        image = imageModelMock,
        text = textMock
    )
}