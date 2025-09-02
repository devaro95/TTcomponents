package com.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ComponentType
import com.components.icon.TTIcon
import com.components.styles.*
import com.sample.SampleEvents.Detail
import com.ttcomponents.app.R
import com.vro.compose.screen.VROScreenContent

class SampleScreenContent : VROScreenContent<SampleState, SampleEvents>() {

    val itemList = listOf(
        ItemList("Bullet", ComponentType.BULLET),
        ItemList("Button", ComponentType.BUTTON),
    )

    @Composable
    override fun Content(state: SampleState) {
        LazyColumn(
            modifier = Modifier
                .background(Background)
                .fillMaxSize()
        ) {
            items(itemList) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = { event(Detail(it.componentType)) }
                            )
                            .padding(vertical = 10.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.text,
                            modifier = Modifier.weight(1f),
                            fontSize = 16.sp,
                            color = Primary
                        )
                        TTIcon(
                            iconRes = R.drawable.ic_back,
                            modifier = Modifier.rotate(180f)
                        )
                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        modifier = Modifier.fillMaxWidth(),
                        color = Secondary
                    )
                }
            }
        }
    }

    @Composable
    override fun ScreenPreview() {
        Content(SampleState.INITIAL)
    }

    data class ItemList(
        val text: String,
        val componentType: ComponentType,
    )
}