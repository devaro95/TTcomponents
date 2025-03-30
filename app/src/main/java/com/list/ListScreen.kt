package com.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.icon.TTIcon
import com.components.styles.White
import com.list.ListEvents.Detail
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.utils.topBarBackState
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

private const val ICON_ROTATION = 180f

class ListScreen : VROScreen<ListState, ListEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarBackState(::navigateBack)

    @Composable
    override fun ScreenContent(state: ListState) {
        state.category?.let { category ->
            UpdateTopBar {
                topBarBackState(
                    navigateBack = ::navigateBack,
                    title = category.title
                )
            }
            LazyColumn(
                modifier = Modifier
                    .background(TTTheme.colorScheme.background)
                    .fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(category.componentTypes) {
                    Column(
                        modifier = Modifier
                            .border(1.dp, TTTheme.colorScheme.primaryColor, RoundedCornerShape(16.dp))
                            .clip(RoundedCornerShape(16.dp))
                            .background(White),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(
                                    onClick = { event(Detail(it)) }
                                )
                                .padding(vertical = 16.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = it.value,
                                modifier = Modifier.weight(1f),
                                fontSize = 14.sp,
                                color = TTTheme.colorScheme.primaryColor,
                                fontWeight = FontWeight.Bold
                            )
                            TTIcon(
                                iconRes = R.drawable.ic_back,
                                modifier = Modifier.rotate(ICON_ROTATION),
                                tint = TTTheme.colorScheme.primaryColor
                            )
                        }
                    }
                }
            }
        }
    }

    @VROLightMultiDevicePreview
    @Composable
    override fun ScreenPreview() {
        ScreenContent(ListState.INITIAL)
    }
}
