package com.builder

import androidx.compose.runtime.Composable
import com.components.card.TTCardSelector
import com.model.ComponentType
import com.model.ComponentType.*
import com.model.ComponentType.Category.Button
import com.model.ComponentType.Category.Card
import com.model.ComponentType.Category.Input
import com.model.ComponentType.Category.Menu
import com.model.ComponentType.Category.Section
import com.sections.button.*
import com.sections.card.TTCardAddImageCarouselSection
import com.sections.card.TTCardAddImageSection
import com.sections.card.TTCardSelectorSection
import com.sections.card.TTCardSocialSection
import com.sections.card.TTCardSocialTwoSection
import com.sections.guideSection.bullet.TTBulletSection
import com.sections.guideSection.image.*
import com.sections.guideSection.indicator.TTPagerIndicatorSection
import com.sections.guideSection.info.TTInfoSection
import com.sections.guideSection.paragraph.TTParagraphSection
import com.sections.input.*
import com.sections.menu.TTMenuRoundedSection
import com.sections.menu.TTMenuSection

@Composable
fun RenderSections(type: ComponentType) {
    when (type.category) {
        Button -> RenderButton(type)
        Input -> RenderInput(type)
        Menu -> RenderMenu(type)
        Card -> RenderCard(type)
        Section -> RenderSection(type)
    }
}

@Composable
private fun RenderButton(type: ComponentType) {
    when (type) {
        TTButton -> TTButtonSection()
        TTButtonIconSquare -> TTButtonIconSquareSection()
        TTButtonSave -> TTButtonSaveSection()
        TTButtonSecondary -> TTButtonSecondarySection()
        TTFloatingButton -> TTFloatingButtonSection()
        else -> error("Invalid Button type")
    }
}

@Composable
private fun RenderInput(type: ComponentType) {
    when (type) {
        TTInput -> TTInputSection()
        TTInputClickableDropdown -> TTInputClickableDropdownSection()
        TTInputCurrency -> TTInputCurrencySection()
        TTInputCurrencyPicker -> TTInputCurrencyPickerSection()
        TTInputDate -> TTInputDateSection()
        TTInputDropdown -> TTInputDropdownSection()
        TTInputMenuDropdown -> TTInputMenuDropdownSection()
        TTInputPassword -> TTInputPasswordSection()
        else -> error("Invalid Input type")
    }
}

@Composable
private fun RenderMenu(type: ComponentType) {
    when (type) {
        TTMenu -> TTMenuSection()
        TTMenuRounded -> TTMenuRoundedSection()
        else -> error("Invalid Menu type")
    }
}

@Composable
private fun RenderCard(type: ComponentType) {
    when (type) {
        TTCardImage -> TTCardAddImageSection()
        TTCardImageCarousel -> TTCardAddImageCarouselSection()
        TTCardSocial -> TTCardSocialSection()
        TTCardSocialTwo -> TTCardSocialTwoSection()
        TTCardSelector -> TTCardSelectorSection()
        else -> error("Invalid Card type")
    }
}

@Composable
private fun RenderSection(type: ComponentType) {
    when (type) {
        TTBullet -> TTBulletSection()
        TTImageCardHeader -> TTImageCardHeaderSection()
        TTImageFull -> TTImageFullSection()
        TTInfo -> TTInfoSection()
        TTPagerIndicator -> TTPagerIndicatorSection()
        TTParagraph -> TTParagraphSection()
        TTUserImage -> TTUserImageSection()
        else -> error("Invalid Section type")
    }
}