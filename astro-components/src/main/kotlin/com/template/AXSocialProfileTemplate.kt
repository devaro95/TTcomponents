package com.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.button.AXButton
import com.components.icon.AXIcon
import com.theming.AXTheme
import com.theming.colors.AXColors
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun AXSocialProfileTemplate(
    image: Int,
    followers: String,
    following: String,
    userImage: Int,
    imageList: List<Int>,
    colors: AXColors = AXTheme.colorScheme,
) {
    Column {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(colors.background)
                    .align(Alignment.BottomCenter)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = followers
                    )
                    Text(
                        text = "Followers"
                    )
                }
                AXIcon(
                    iconRes = userImage,
                    size = 70.dp
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = following
                    )
                    Text(
                        text = "Following"
                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.background)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Alvaro Montero")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(horizontal = 60.dp),
                text = "Android Developer. Programador desde xiquitito",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                AXButton(
                    text = "Follow",
                    onClick = {}
                )
                AXButton(
                    text = "Message",
                    onClick = {}
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            LazyVerticalGrid(
                modifier = Modifier
                    .sizeIn(minWidth = 50.dp)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(imageList) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Image(
                            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                            painter = painterResource(image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun AXSocialProfileTemplatePreview() {
    AXSocialProfileTemplate(
        image = R.drawable.italia,
        followers = "43000",
        following = "537",
        userImage = R.drawable.ic_avatar_bear,
        imageList = listOf(1, 2, 3, 4, 5)
    )
}