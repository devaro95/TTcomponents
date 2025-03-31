package com.components.cardcarousel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.cardcarousel.TTCardCarouselType.SMALL
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.section.TTSection
import com.components.styles.White
import com.components.text.AXBodyText
import com.components.text.AXHeaderText14
import com.domain.model.SectionModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselItemPreview() {
    TTCardCarousel(
        items = listOf(
            TTCardCarouselItem(
                "Title text",
                "Message text"
            ),
            TTCardCarouselItem(
                "Title text",
                "Message text"
            )
        ),
        type = SMALL,
        isEditable = true,
        showSocials = true,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardCarousel(
    modifier: Modifier = Modifier,
    items: List<TTCardCarouselItem>,
    type: TTCardCarouselType,
    isEditable: Boolean,
    showSocials: Boolean,
    buttonText: String? = null,
) {
    TTSection(
        params = BuildSectionParams(
            isEditable = isEditable,
            showButton = showSocials,
            sectionModel = SectionModel.BulletSection.Bullet(),
            buttonText = buttonText
        )
    ) {
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyRow(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    TTCardCarouselItem(it, type)
                }
            }
        }
    }
}


@Composable
private fun TTCardCarouselItem(
    item: TTCardCarouselItem,
    type: TTCardCarouselType,
) {
    ElevatedCard(
        modifier = Modifier
            .width(type.width.dp)
            .height(140.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            AXHeaderText14(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                text = item.title,
            )
            AXBodyText(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                text = item.message,
                minLines = 6
            )
        }
    }
}

data class TTCardCarouselItem(
    val title: String,
    val message: String,
)

enum class TTCardCarouselType(val width: Int) {
    SMALL(140), BIG(250)
}