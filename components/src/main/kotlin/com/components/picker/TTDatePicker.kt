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
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText30
import com.extensions.*
import com.theming.TTTheme
import com.theming.colors.TTDatePickerColors
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import java.time.LocalDate
import java.util.Date

/**
 * `TTDatePicker` is a composable function that creates a date picker dialog.
 *
 * This component displays a dialog that allows the user to select a date. It provides
 * customization options for the date range, colors, and actions to be performed on confirm or cancel.
 *
 * @param selectedDate The initially selected date in milliseconds. Defaults to the current date and time.
 * @param title The title text to be displayed at the top of the date picker.
 * @param startSelectableDate An optional start date in milliseconds that defines the beginning of the
 *                            selectable date range. If not provided, the current date will be used.
 * @param colors Custom colors to be used for the date picker. Defaults to `TTDatePickerColors.defaultColors`.
 * @param onConfirm Lambda that is invoked when the user confirms the selected date. It provides the
 *                  selected date in milliseconds.
 * @param onCancel Lambda that is invoked when the user cancels the date picker dialog.
 *
 * Example Usage:
 * @sample TTDatePickerPreview
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTDatePicker(
    selectedDate: Long = Date().time,
    title: String,
    startSelectableDate: Long? = null,
    colors: TTDatePickerColors = TTDatePickerColors.defaultColors,
    onConfirm: (Long) -> Unit,
    onCancel: () -> Unit,
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
                selectedDayContentColor = colors.selectedDayContentColor,
                dividerColor = colors.dividerColor,
                yearContentColor = colors.yearContentColor,
                selectedYearContentColor = colors.selectedYearContentColor,
                selectedYearContainerColor = colors.selectedYearContainerColor,
                containerColor = colors.containerColor,
                disabledDayContentColor = colors.disabledDayContentColor,
                dayContentColor = colors.dayContentColor,
                weekdayContentColor = colors.weekdayContentColor,
                todayContentColor = colors.todayContentColor,
                navigationContentColor = colors.navigationContentColor
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
                    selectedDayContentColor = colors.selectedDayContentColor,
                    dividerColor = colors.dividerColor,
                    yearContentColor = colors.yearContentColor,
                    selectedYearContentColor = colors.selectedYearContentColor,
                    selectedYearContainerColor = colors.selectedYearContainerColor,
                    containerColor = colors.containerColor,
                    disabledDayContentColor = colors.disabledDayContentColor,
                    dayContentColor = colors.dayContentColor,
                    weekdayContentColor = colors.weekdayContentColor,
                    todayContentColor = colors.todayContentColor,
                    navigationContentColor = colors.navigationContentColor
                ),
                headline = {
                    TTHeaderText30(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = state.selectedDateMillis?.toLocalDate()
                            ?.toString(DATE_FORMAT_MONTH_CHAR)
                            .orEmpty(),
                        color = colors.yearContentColor
                    )
                },
                showModeToggle = false
            )
        }
    }
}

/**
 * `DatePickerButton` is a composable function that creates a custom button for use in a date picker.
 *
 * This component provides a styled button with a circular shape and customizable text and colors,
 * typically used for "Confirm" and "Cancel" actions in a `TTDatePicker` dialog.
 *
 * @param modifier Modifier to apply to the button. Use this to control layout properties, such as
 *                 padding, size, and alignment.
 * @param text The text to be displayed on the button.
 * @param textColor The color of the text on the button.
 * @param containerColor The background color of the button.
 * @param onClick Lambda that is invoked when the button is clicked.
 *
 */
@Composable
private fun DatePickerButton(
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TTDatePicker(
            title = "Select a Date",
            onConfirm = { },
            onCancel = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTDatePicker(
            title = "Select a Date",
            startSelectableDate = Date().time,
            onConfirm = { },
            onCancel = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        val preselectedDate = Date().time + (1000 * 60 * 60 * 24 * 15) // 15 days from now
        TTDatePicker(
            selectedDate = preselectedDate,
            title = "Select a Date",
            onConfirm = { },
            onCancel = { }
        )
    }
}