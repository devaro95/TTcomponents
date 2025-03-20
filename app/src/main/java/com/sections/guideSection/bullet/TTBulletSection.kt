package com.sections.guideSection.bullet

import androidx.compose.runtime.Composable
import com.components.bullet.TTBullet
import com.components.bullet.TTBulletItemData
import com.mock.textMock
import com.mock.titleMock

@Composable
fun TTBulletSection() {
    TTBullet(
        title = titleMock,
        itemList = listOf(
            TTBulletItemData(
                title = titleMock,
                text = textMock
            ),
            TTBulletItemData(
                title = titleMock,
                text = textMock
            ),
            TTBulletItemData(
                title = titleMock,
                text = textMock
            )
        )
    )
}