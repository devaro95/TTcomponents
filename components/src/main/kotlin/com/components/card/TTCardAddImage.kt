package com.components.card

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.*
import com.components.text.AXHeaderText14
import com.domain.model.GuideModel.ImageModel
import com.extensions.toBitmap
import com.mock.imageMock
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTCardAddImage` is a composable function that creates a card for displaying an image,
 * with the option to add or edit an image.
 *
 * This component is designed to handle different image states:
 * - Displaying an image from a base64 string.
 * - Displaying an image from a URL.
 * - Displaying a placeholder with an "add" icon when no image is available.
 *
 * It also includes an "edit" overlay for existing images.
 *
 * @param modifier Modifier to apply to the outer `Row` of the card.
 *                 Use this to control layout properties like padding and alignment.
 * @param height The height of the card. Defaults to 180.dp.
 * @param image An `ImageModel` object containing either `imageBase64` (base64 encoded string) or
 *              `imageUrl` (a URL string) of the image to display.
 * @param onClick Lambda that is invoked when the card or the edit button is clicked.
 *
 * Example Usage:
 * @sample TTCardAddImagePreview
 *
 */
@Composable
fun TTCardAddImage(
    modifier: Modifier = Modifier,
    height: Dp = 180.dp,
    image: ImageModel,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(8.dp))
            .background(SecondaryBackground)
            .border(1.dp, InputBorder, RoundedCornerShape(8.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (image.imageBase64.isNotEmpty()) {
                Image(
                    bitmap = image.imageBase64.toBitmap().asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            } else if (image.imageUrl.isNotEmpty()) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = image.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    TTIcon(
                        iconRes = R.drawable.ic_add,
                        size = 24.dp,
                        tint = Placeholder,
                        onClick = onClick
                    )
                }
            }
            if (image.imageBase64.isNotEmpty() || image.imageUrl.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .background(EditionBackground)
                        .align(Alignment.BottomCenter)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = onClick,
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TTIcon(
                        iconRes = R.drawable.ic_edit,
                        size = 20.dp,
                        tint = White,
                        onClick = onClick
                    )
                    AXHeaderText14(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Editar",
                        color = White,
                    )
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
fun TTCardAddImagePreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        var imageModelEmpty by remember { mutableStateOf(ImageModel()) }
        TTCardAddImage(
            image = imageModelEmpty,
            onClick = { println("Clicked on Placeholder") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var imageModelUrl by remember { mutableStateOf(ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+From+URL")) }
        TTCardAddImage(
            image = imageModelUrl,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        var imageModelHeight by remember { mutableStateOf(ImageModel(imageUrl = "https://via.placeholder.com/600x400?text=Image+From+URL")) }
        TTCardAddImage(
            image = imageModelHeight,
            onClick = {
                println("Clicked on height image")
            },
            height = 300.dp
        )
    }
}