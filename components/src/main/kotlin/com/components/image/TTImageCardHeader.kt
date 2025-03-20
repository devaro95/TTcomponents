package com.components.image

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.styles.White
import com.components.text.TTHeaderText16
import com.domain.model.GuideModel.ImageModel
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.mock.imageModelMock
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ONE

/**
 * A composable that displays a card with a header, a horizontal image pager, and an indicator.
 *
 * This composable is designed to display a card with the following elements:
 * - A header text (title).
 * - A horizontal pager to display multiple images.
 * - An indicator to show the current page in the pager if more than one image is displayed.
 *
 * @param imageList The list of [ImageModel] to display in the pager.
 * @param title The text to display in the header of the card. Defaults to an empty string.
 * @param modifier Modifier to be applied to the card.
 *
 * Example usage:
 * @sample TTImageCardHeaderPreview
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTImageCardHeader(
    modifier: Modifier = Modifier,
    imageList: List<ImageModel>,
    title: String = EMPTY_STRING,
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        TTHeaderText16(
            text = title,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        val pagerState = rememberPagerState(pageCount = { imageList.size })
        HorizontalPager(pagerState) {
            Column {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(top = 8.dp)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    model = imageList[it].imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier.height(16.dp))
        if (imageList.size > INT_ONE) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pageCount = imageList.size,
                    pagerState = pagerState
                )
            }
        }
    }
}

/**
 * Example usage of the TTImageCardHeader composable.
 */
@VROLightMultiDevicePreview
@Composable
fun TTImageCardHeaderPreview() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TTImageCardHeader(
            title = titleMock,
            imageList = listOf(imageModelMock),
        )
        TTImageCardHeader(
            title = titleMock,
            imageList = listOf(imageModelMock, imageModelMock, imageModelMock),
        )
    }
}
