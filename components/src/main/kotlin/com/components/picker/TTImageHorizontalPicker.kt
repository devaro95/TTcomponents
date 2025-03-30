package com.components.picker

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tornado
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.text.TTBodyText
import com.components.text.TTHeaderText24
import com.extensions.isUrl
import com.extensions.toBitmap
import com.mock.imageBase64Mock
import com.mock.imageMock
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

/**
 * `TTImageHorizontalPicker` is a composable function that creates a horizontal picker for
 * selecting images.
 *
 * This component displays a horizontal, scrollable list of images, allowing users to select one.
 * It supports both predefined images (provided as `Painter`s) and a custom image (provided as a
 * Base64 string or an URL). The component also includes a title, message, optional footer text,
 * customizable icons, and an option to handle adding a custom image.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the picker.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param textModifier Modifier to apply to the title and message text.
 * @param images A list of `Painter` objects representing the predefined images to display in the picker.
 * @param initialSelectedIndex The index of the initially selected image. Defaults to `INT_ZERO`.
 * @param customImage An optional Base64 string or an URL of a custom uploaded image. If provided,
 *                    this image will be added to the beginning of the picker.
 * @param showCustomImage Boolean to define if the custom image is visible. By default is true.
 * @param pickerIconRes Optional drawable resource ID for the icons at the top and bottom of the
 *                      picker. If `null`, the default `Tornado` icon is used.
 * @param title Optional title text to be displayed above the picker.
 * @param message Optional message text to be displayed below the title.
 * @param footerText Optional text to be displayed below the picker.
 * @param textAlign Optional text alignment for the title, message, and footer text. If `null`,
 *                  the default text alignment is used.
 * @param onImageSelected Lambda that is invoked when an image is selected. It provides the index of the selected image.
 * @param onAddImage Lambda that is invoked when the user clicks on the "add image" button (the
 *                   custom image slot).
 *
 * Example Usage:
 * @sample TTImageHorizontalPickerPreview
 *
 */
@Composable
fun TTImageHorizontalPicker(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    images: List<Painter>,
    initialSelectedIndex: Int = INT_ZERO,
    customImage: String? = null,
    showCustomImage: Boolean = true,
    pickerIconRes: Int? = null,
    title: String? = null,
    message: String? = null,
    footerText: String? = null,
    textAlign: TextAlign? = null,
    onImageSelected: (Int) -> Unit,
    onAddImage: () -> Unit,
) {
    val combinedImages = remember(customImage, images) {
        if (customImage != null) {
            mutableListOf<Any>().apply {
                if (showCustomImage) add(customImage)
                addAll(images)
            }
        } else {
            images
        }
    }

    val pagerState = rememberPagerState(pageCount = { combinedImages.size })

    var selectedIndex by remember { mutableIntStateOf(initialSelectedIndex) }

    LaunchedEffect(initialSelectedIndex) {
        pagerState.scrollToPage(initialSelectedIndex)
        selectedIndex = initialSelectedIndex
    }

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
        onImageSelected(selectedIndex)
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title?.let {
            TTHeaderText24(
                modifier = textModifier.fillMaxWidth(),
                text = it,
                textAlign = textAlign
            )
        }
        message?.let {
            TTBodyText(
                modifier = textModifier.fillMaxWidth(),
                text = message,
                textAlign = textAlign
            )
        }

        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .size(24.dp),
            imageVector = pickerIconRes?.let { ImageVector.vectorResource(it) } ?: Icons.Default.Tornado,
            contentDescription = EMPTY_STRING,
            tint = TTTheme.colorScheme.secondaryColor
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 120.dp),
                pageSpacing = 22.dp,
                flingBehavior = PagerDefaults.flingBehavior(
                    state = pagerState,
                    pagerSnapDistance = PagerSnapDistance.atMost(INT_ZERO)
                ),
            ) { page ->
                val isCustomImage = customImage != null && page == INT_ZERO
                val painter = combinedImages[page]

                Box(
                    modifier = Modifier
                        .imageModifier(
                            isCurrentPage = page == pagerState.currentPage,
                            onClick = {
                                if (isCustomImage) {
                                    onAddImage()
                                } else {
                                    selectedIndex = page
                                    onImageSelected(page)
                                }
                            },
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.Center)
                            .border(2.dp, TTTheme.colorScheme.primaryColor, CircleShape)
                            .clip(CircleShape),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        when {
                            isCustomImage && customImage.isUrl() -> {
                                AsyncImage(
                                    modifier = Modifier.fillMaxSize(),
                                    model = customImage,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }

                            isCustomImage && !customImage.isUrl() -> {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    bitmap = customImage.toBitmap().asImageBitmap(),
                                    contentDescription = EMPTY_STRING,
                                    contentScale = ContentScale.Crop
                                )
                            }

                            else -> {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painter as Painter,
                                    contentDescription = EMPTY_STRING,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
        }

        Icon(
            modifier = Modifier
                .padding(top = 40.dp)
                .rotate(180f)
                .size(24.dp),
            imageVector = pickerIconRes?.let { ImageVector.vectorResource(it) } ?: Icons.Default.Tornado,
            contentDescription = EMPTY_STRING,
            tint = TTTheme.colorScheme.secondaryColor
        )

        footerText?.let {
            TTBodyText(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(),
                text = it,
                textAlign = textAlign
            )
        }
    }
}

/**
 * `imageModifier` is a custom `Modifier` function that enhances an image within a carousel or
 * similar layout.
 *
 * This modifier provides click handling and a scaling effect to visually emphasize the currently
 * selected or focused image in a horizontally scrolling list.
 *
 * @param isCurrentPage Boolean flag indicating whether this image is the currently selected or
 *                      focused image in the carousel.
 * @param onClick Lambda function that is invoked when the image is clicked.
 */
@Composable
private fun Modifier.imageModifier(
    isCurrentPage: Boolean,
    onClick: () -> Unit,
) = this
    .clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick,
    )
    .fillMaxWidth()
    .size(120.dp)
    .graphicsLayer {
        val scale = if (isCurrentPage) 1.4f else 0.8f
        scaleX = scale
        scaleY = scale
    }

@VROLightMultiDevicePreview
@Composable
private fun TTImageHorizontalPickerPreview() {
    val imageList = listOf(
        painterResource(R.drawable.ic_avatar_avocado),
        painterResource(R.drawable.ic_avatar_cactus),
        painterResource(R.drawable.ic_avatar_lazybones),
        painterResource(R.drawable.ic_avatar_bear)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTImageHorizontalPicker(
            images = imageList,
            title = "Pick your avatar",
            message = "Select from existing avatars",
            footerText = "Or upload your own image!",
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTImageHorizontalPicker(
            images = imageList,
            customImage = imageBase64Mock,
            pickerIconRes = R.drawable.ic_star,
            title = "Pick your avatar",
            message = "Select from existing avatars",
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTImageHorizontalPicker(
            images = imageList,
            customImage = imageMock,
            title = "Pick your avatar",
            message = "Select from existing avatars",
            textAlign = TextAlign.End,
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )
        Spacer(modifier = Modifier.height(16.dp))

        TTImageHorizontalPicker(
            images = imageList,
            title = "Pick your avatar",
            message = "Select from existing avatars",
            showCustomImage = false,
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )
        Spacer(modifier = Modifier.height(16.dp))

        TTImageHorizontalPicker(
            images = imageList,
            initialSelectedIndex = 5,
            title = "Pick your avatar",
            message = "Select from existing avatars",
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )
        Spacer(modifier = Modifier.height(16.dp))

        TTImageHorizontalPicker(
            images = imageList,
            title = "Pick your avatar",
            onImageSelected = { avatarModel -> },
            onAddImage = { },
        )
        Spacer(modifier = Modifier.height(16.dp))

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