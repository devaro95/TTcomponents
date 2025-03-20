package com.components.footer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.components.button.TTButtonIconSquare
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.styles.White
import com.domain.model.SectionModel
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionFooterPreview() {
    TTSectionFooter(
        params = BuildSectionParams(
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
            sectionModel = SectionModel.RouteSection.Route()
        )
    )
}

@Composable
fun TTSectionFooter(
    modifier: Modifier = Modifier,
    params: BuildSectionParams,
) {
    Column {
        Row(modifier = modifier.padding(vertical = 16.dp)) {
            if (params.isEditable) {
                Row {
                    Column {
                        TTButtonIconSquare(
                            iconRes = R.drawable.ic_edit,
                            onClick = { params.onEditSection.invoke(params.sectionModel) }
                        )
                    }
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        TTButtonIconSquare(
                            iconRes = R.drawable.ic_delete,
                            onClick = { params.onDeleteSection.invoke(params.sectionModel) }
                        )
                    }
                }
            }
            if (params.showButton) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TTButtonIconSquare(
                        iconRes = R.drawable.ic_save_section,
                        text = params.buttonText ?: stringResource(R.string.copy_section),
                        onClick = { params.onCopySection(params.sectionModel) },
                        backgroundColor = TTTheme.colorScheme.secondaryColor,
                        contentColor = White
                    )
                }
            }
        }
    }
}