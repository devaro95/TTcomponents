package com.sample

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.icon.TTIcon
import com.components.styles.White
import com.sample.SampleEvents.List
import com.sample.SampleEvents.ThemeChange
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.utils.topBarState
import com.vro.compose.screen.VROScreen
import com.vro.compose.states.VROTopBarBaseState

class SampleScreen : VROScreen<SampleState, SampleEvents>() {

    override fun setTopBar(currentState: VROTopBarBaseState) =
        topBarState(
            title = "Components Repository",
            actionButton = {
                TTIcon(
                    modifier = Modifier.padding(end = 16.dp),
                    iconRes = R.drawable.ic_edit,
                    size = 16.dp,
                    onClick = { event(ThemeChange) }
                )
            }
        )

    @Composable
    override fun ScreenContent(state: SampleState) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(TTTheme.colorScheme.background)
                .padding(top = 24.dp)
        ) {
            items(state.components.allCategories) { item ->
                Box(
                    modifier = Modifier
                        .clickable { event(List(item)) }
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.5.dp, TTTheme.colorScheme.primaryColor, RoundedCornerShape(16.dp))
                        .background(White)
                        .padding(16.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 14.sp,
                            color = TTTheme.colorScheme.primaryColor,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TTIcon(
                            iconRes = item.icon,
                            size = 20.dp,
                            onClick = { event(List(item)) }
                        )
                    }
                }
            }
        }
    }

    @Composable
    override fun ScreenPreview() {
        ScreenContent(SampleState.INITIAL)
    }
}