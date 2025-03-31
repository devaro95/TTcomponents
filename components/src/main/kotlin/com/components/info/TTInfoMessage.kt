package com.components.info

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.info.TTInfoMessageType.BORDER
import com.components.info.TTInfoMessageType.ELEVATED
import com.components.styles.White
import com.components.text.AXBodyText
import com.components.text.AXHeaderText18
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * A composable that displays an informative message in a card format.
 *
 * This composable is used to display important information to the user. It consists of
 * a card that contains a title and a message. The appearance of the card can be
 * customized to be either bordered or elevated.
 *
 * @param modifier Modifier to be applied to the info message.
 * @param title The title of the information message.
 * @param message The main text message to display.
 * @param type The type of the info message, which can be either [TTInfoMessageType.BORDER] or
 *   [TTInfoMessageType.ELEVATED]. This determines whether the card has a border or an elevation.
 *
 * Example usage:
 * @sample TTInfoMessagePreview
 */
@Composable
fun TTInfoMessage(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    type: TTInfoMessageType,
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(160.dp),
            border = getCardBorder(type),
            elevation = getCardElevation(type),
            colors = CardDefaults.cardColors(
                containerColor = White
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                AXHeaderText18(text = title)
                AXBodyText(
                    modifier = Modifier.padding(top = 8.dp),
                    text = message
                )
            }
        }
    }
}

/**
 * Enumeration of the available types of information messages.
 *
 * This enum defines the different styles that can be applied to an info message card.
 *
 * @property BORDER Indicates that the info message card should have a border.
 * @property ELEVATED Indicates that the info message card should have an elevation.
 */
enum class TTInfoMessageType {
    /**
     * A bordered info message.
     */
    BORDER,

    /**
     * An elevated info message.
     */
    ELEVATED
}

/**
 * Returns the border for the info message card based on the provided [type].
 *
 * @param type The [TTInfoMessageType] to determine the border style.
 * @return A [BorderStroke] if the type is [TTInfoMessageType.BORDER], otherwise null.
 */
@Composable
private fun getCardBorder(type: TTInfoMessageType): BorderStroke? {
    return when (type) {
        BORDER -> BorderStroke(1.dp, TTTheme.colorScheme.primaryColor)
        ELEVATED -> null
    }
}

/**
 * Returns the elevation for the info message card based on the provided [type].
 *
 * @param type The [TTInfoMessageType] to determine the elevation style.
 * @return A [CardElevation] that represents the elevation for the given type.
 */
@Composable
private fun getCardElevation(type: TTInfoMessageType): CardElevation {
    return when (type) {
        BORDER -> {
            CardDefaults.cardElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                focusedElevation = 0.dp,
                hoveredElevation = 0.dp,
                draggedElevation = 0.dp,
                disabledElevation = 0.dp,
            )
        }

        ELEVATED -> CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        )
    }
}

/**
 * Example usage of the TTInfoMessage composable.
 */
@VROLightMultiDevicePreview
@Composable
fun TTInfoMessagePreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTInfoMessage(
            title = "This is a BORDER title",
            message = "This is a BORDER message",
            type = BORDER
        )
        TTInfoMessage(
            title = "This is an ELEVATED title",
            message = "This is an ELEVATED message",
            type = ELEVATED
        )
    }
}