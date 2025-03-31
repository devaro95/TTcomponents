package com.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.core.graphics.toColorInt
import com.components.button.TTButton
import com.components.icon.TTIcon
import com.components.input.AXInput
import com.components.input.AXInputClickableDropdownNew
import com.github.skydoves.colorpicker.compose.*
import com.mock.titleMock
import com.model.Configuration
import com.theme.ThemeChangeViewModel.Companion.toHex
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTThemeListItem(
    configuration: Configuration,
    color: Color,
    onChange: (Configuration, Color) -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf<Color?>(null) }
    var colorHex by remember { mutableStateOf<String>(color.toHex()) }
    var buttonError by remember { mutableStateOf<Boolean>(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AXInputClickableDropdownNew(
            modifier = Modifier.padding(horizontal = 24.dp),
            value = color.toHex(),
            onClick = {
                showDialog = true
            },
            placeholder = configuration.title
        )
        val controller = rememberColorPickerController()
        if (showDialog) {
            BasicAlertDialog(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                onDismissRequest = {
                    showDialog = false
                },
                properties = DialogProperties(usePlatformDefaultWidth = false),
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TTIcon(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp),
                            iconRes = R.drawable.ic_cross,
                            size = 24.dp,
                            onClick = { showDialog = false }
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.weight(1f)
                        ) {
                            HsvColorPicker(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(300.dp)
                                    .padding(10.dp),
                                controller = controller,
                                onColorChanged = { colorEnvelope: ColorEnvelope ->
                                    selectedColor = colorEnvelope.color
                                    colorHex = colorEnvelope.hexCode
                                    buttonError = false
                                },
                                initialColor = color,
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            AXInput(
                                modifier = Modifier.padding(horizontal = 24.dp),
                                value = colorHex,
                                onChange = {
                                    colorHex = it
                                    try {
                                        val color = Color(("#$colorHex").toColorInt())
                                        selectedColor = color
                                        buttonError = false
                                    } catch (_: Exception) {
                                        buttonError = true
                                    }
                                },
                                isError = buttonError,
                                errorText = "Introduce un color válido"
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            TTButton(
                                text = "Aceptar",
                                onClick = {
                                    selectedColor?.let {
                                        onChange(configuration, it)
                                        showDialog = false
                                    }
                                },
                                enabled = buttonError == false
                            )
                        }
                    }
                }
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTThemeListItemPreview() {
    TTThemeListItem(
        configuration = Configuration.INPUT_BORDER,
        color = Color.Red,
        onChange = { _, _ -> }
    )
}