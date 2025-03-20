package com.components.carousel

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.icon.TTIcon
import com.components.text.TTBodyText
import com.components.text.TTHeaderText24
import com.domain.model.AvatarModel
import com.extensions.toBitmap
import com.mapper.toDrawable
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTAvatarCarousel(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    initialPage: AvatarModel? = AvatarModel.CUSTOM,
    customImage: String = EMPTY_STRING,
    imageUrl: String = EMPTY_STRING,
    title: String,
    message: String,
    footerText: String = EMPTY_STRING,
    textAlign: TextAlign? = null,
    onItemScroll: (AvatarModel) -> Unit,
    onAddImageClick: () -> Unit,
) {

    val iconList = AvatarModel.entries

    val pagerState = rememberPagerState(pageCount = { iconList.size })
    LaunchedEffect(Unit) {
        snapshotFlow { pagerState.currentPage }
            .collect { page ->
                onItemScroll(iconList[page])
            }
    }

    var selectedPage by remember { mutableStateOf(initialPage) }

    LaunchedEffect(initialPage) {
        selectedPage = initialPage
    }

    LaunchedEffect(selectedPage) {
        pagerState.animateScrollToPage(iconList.indexOf(selectedPage))
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TTHeaderText24(
            modifier = textModifier.fillMaxWidth(),
            text = title,
            textAlign = textAlign
        )
        TTBodyText(
            modifier = textModifier
                .fillMaxWidth(),
            text = message,
            textAlign = textAlign
        )
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            imageVector = Icons.Default.Tornado,
            contentDescription = null,
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
                    pagerSnapDistance = PagerSnapDistance.atMost(0)
                ),
            ) { page ->
                if (iconList[page] == AvatarModel.CUSTOM && customImage.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .imageModifier(
                                isCurrentPage = page == pagerState.currentPage,
                                onClick = {
                                    if (iconList[pagerState.currentPage] == AvatarModel.CUSTOM) {
                                        onAddImageClick()
                                    } else {
                                        selectedPage = iconList[page]
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
                            Image(
                                bitmap = customImage.toBitmap().asImageBitmap(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                } else if (iconList[page] == AvatarModel.CUSTOM && imageUrl.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .imageModifier(
                                isCurrentPage = page == pagerState.currentPage,
                                onClick = {
                                    if (iconList[pagerState.currentPage] == AvatarModel.CUSTOM) {
                                        onAddImageClick()
                                    } else {
                                        selectedPage = iconList[page]
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
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(10.dp)),
                                model = imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                } else if (iconList[page] == AvatarModel.CUSTOM && customImage.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .imageModifier(
                                isCurrentPage = page == pagerState.currentPage,
                                onClick = {
                                    if (iconList[pagerState.currentPage] == AvatarModel.CUSTOM) {
                                        onAddImageClick()
                                    } else {
                                        selectedPage = iconList[page]
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
                            TTIcon(
                                iconRes = R.drawable.ic_plus,
                                size = 24.dp,
                                onClick = {
                                    if (iconList[pagerState.currentPage] == AvatarModel.CUSTOM) {
                                        onAddImageClick()
                                    } else {
                                        selectedPage = iconList[page]
                                    }
                                }
                            )
                        }
                    }
                } else {
                    Image(
                        modifier = Modifier.imageModifier(
                            isCurrentPage = page == pagerState.currentPage,
                            onClick = { selectedPage = iconList[page] },
                        ),
                        painter = painterResource(iconList[page].toDrawable()),
                        contentDescription = null,
                    )
                }
            }
        }
        Icon(
            modifier = Modifier
                .padding(top = 40.dp)
                .rotate(180f),
            imageVector = Icons.Default.Tornado,
            contentDescription = null,
            tint = TTTheme.colorScheme.secondaryColor
        )
        if (footerText.isNotEmpty()) {
            TTBodyText(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(),
                text = footerText,
                textAlign = textAlign
            )
        }
    }
}

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
private fun TTAvatarCarouselPreview() {
    TTAvatarCarousel(
        initialPage = AvatarModel.CUSTOM,
        onItemScroll = {},
        onAddImageClick = {},
        title = "Selecciona tu Avatar",
        message = "Esta imagen será la que vean todos los usuarios.",
        footerText = "O sube una foto tuya",
    )
}