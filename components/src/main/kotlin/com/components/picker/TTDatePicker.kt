package com.components.picker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.styles.Placeholder
import com.components.styles.White
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText30
import com.extensions.*
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import java.time.LocalDate
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTDatePicker(
    selectedDate: Long = Date().time,
    title: String,
    onConfirm: (Long) -> Unit,
    onCancel: () -> Unit,
    startSelectableDate: Long? = null,
) {
    val state = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate,
        yearRange = IntRange(LocalDate.now().year.dec(), LocalDate.now().year.inc()),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= (startSelectableDate ?: LocalDate.now().atStartOfDay()
                    .time())
                        && utcTimeMillis <= LocalDate.now().plusYears(1).atStartOfDay().time()
            }

            override fun isSelectableYear(year: Int): Boolean {
                return year <= LocalDate.now().year.inc()
            }
        }
    )
    Column(
        modifier = Modifier
    ) {
        DatePickerDialog(
            modifier = Modifier
                .scale(0.9f)
                .padding(vertical = 16.dp),
            onDismissRequest = { },
            confirmButton = {
                Row(modifier = Modifier.padding(end = 16.dp, bottom = 8.dp)) {
                    DatePickerButton(
                        text = stringResource(R.string.accept),
                        textColor = Color.White,
                        containerColor = TTTheme.colorScheme.secondaryColor,
                        onClick = { state.selectedDateMillis?.let { onConfirm(it) } }
                    )
                }
            },
            dismissButton = {
                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    DatePickerButton(
                        text = stringResource(R.string.cancel),
                        textColor = TTTheme.colorScheme.primaryColor,
                        containerColor = TTTheme.colorScheme.background,
                        onClick = onCancel
                    )
                }
            },
            colors = DatePickerDefaults.colors(
                selectedDayContentColor = Color.White,
                dividerColor = Color.White,
                yearContentColor = TTTheme.colorScheme.secondaryColor,
                selectedYearContentColor = Color.White,
                selectedYearContainerColor = TTTheme.colorScheme.secondaryColor,
                containerColor = TTTheme.colorScheme.background,
                disabledDayContentColor = Color(0xFFD6D6D6),
                dayContentColor = TTTheme.colorScheme.primaryColor,
                weekdayContentColor = TTTheme.colorScheme.secondaryColor,
                todayContentColor = TTTheme.colorScheme.primaryColor,
                navigationContentColor = TTTheme.colorScheme.primaryColor,
            )
        ) {
            DatePicker(
                modifier = Modifier.navigationBarsPadding(),
                state = state,
                title = {
                    TTHeaderText16(
                        modifier = Modifier.padding(start = 24.dp, top = 24.dp),
                        text = title
                    )
                },
                colors = DatePickerDefaults.colors(
                    selectedDayContentColor = Color.White,
                    dividerColor = TTTheme.colorScheme.background,
                    yearContentColor = White,
                    selectedYearContentColor = TTTheme.colorScheme.background,
                    selectedYearContainerColor = White,
                    containerColor = TTTheme.colorScheme.background,
                    disabledDayContentColor = Placeholder,
                    dayContentColor = TTTheme.colorScheme.primaryColor,
                    weekdayContentColor = White,
                    todayContentColor = TTTheme.colorScheme.primaryColor,
                    navigationContentColor = TTTheme.colorScheme.primaryColor,
                ),
                headline = {
                    TTHeaderText30(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = state.selectedDateMillis?.toLocalDate()
                            ?.toString(DATE_FORMAT_MONTH_CHAR)
                            .orEmpty(),
                        color = White
                    )
                },
                showModeToggle = false
            )
        }
    }
}

@Composable
fun DatePickerButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    containerColor: Color,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = CircleShape.copy(CornerSize(10.dp)),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = textColor
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTDatePickerPreview() {
    TTDatePicker(
        title = "Selecciona una fecha",
        onConfirm = {},
        onCancel = {}
    )
}