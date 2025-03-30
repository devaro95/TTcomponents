package com.render

import androidx.compose.runtime.Composable
import com.model.ComponentType
import com.model.ComponentType.Category
import com.model.ComponentType.SocialBox
import com.model.ComponentType.TTBullet
import com.model.ComponentType.TTButton
import com.model.ComponentType.TTButtonIconSquare
import com.model.ComponentType.TTButtonSave
import com.model.ComponentType.TTButtonSecondary
import com.model.ComponentType.TTCardCarouselText
import com.model.ComponentType.TTCardCarouselTitle
import com.model.ComponentType.TTCardCarouselTitleElevated
import com.model.ComponentType.TTCardImage
import com.model.ComponentType.TTCardImageCarousel
import com.model.ComponentType.TTCardSelector
import com.model.ComponentType.TTCardSelectorList
import com.model.ComponentType.TTCardSocial
import com.model.ComponentType.TTCardSocialTwo
import com.model.ComponentType.TTCurrencyPicker
import com.model.ComponentType.TTDatePicker
import com.model.ComponentType.TTFloatingButton
import com.model.ComponentType.TTImageCardHeader
import com.model.ComponentType.TTImageFull
import com.model.ComponentType.TTImageHorizontalPicker
import com.model.ComponentType.TTImagePicker
import com.model.ComponentType.TTInfo
import com.model.ComponentType.TTInput
import com.model.ComponentType.TTInputClickableDropdown
import com.model.ComponentType.TTInputCurrency
import com.model.ComponentType.TTInputCurrencyPicker
import com.model.ComponentType.TTInputDate
import com.model.ComponentType.TTInputDropdown
import com.model.ComponentType.TTInputMenuDropdown
import com.model.ComponentType.TTInputPassword
import com.model.ComponentType.TTListPicker
import com.model.ComponentType.TTMenu
import com.model.ComponentType.TTMenuRounded
import com.model.ComponentType.TTPager
import com.model.ComponentType.TTPagerIndicator
import com.model.ComponentType.TTParagraph
import com.model.ComponentType.TTProgressBar
import com.model.ComponentType.TTStepperTextIndicator
import com.model.ComponentType.TTUserImage
import com.sections.box.TTSocialBoxSection
import com.sections.button.*
import com.sections.card.*
import com.sections.counter.TTCounterSection
import com.sections.guideSection.bullet.TTBulletSection
import com.sections.guideSection.image.*
import com.sections.guideSection.indicator.TTStepperTextIndicatorSection
import com.sections.guideSection.info.TTInfoSection
import com.sections.guideSection.paragraph.TTParagraphSection
import com.sections.input.*
import com.sections.menu.TTMenuRoundedSection
import com.sections.menu.TTMenuSection
import com.sections.pager.TTPagerIndicatorSection
import com.sections.pager.TTPagerSection
import com.sections.picker.*
import com.sections.progress.TTProgressBarSection

@Composable
fun RenderSections(type: ComponentType) {
    when (type.category) {
        Category.Button -> RenderButton(type)
        Category.Input -> RenderInput(type)
        Category.Menu -> RenderMenu(type)
        Category.Card -> RenderCard(type)
        Category.Picker -> RenderPicker(type)
        Category.Progress -> RenderProgressBar(type)
        Category.Pager -> RenderPager(type)
        Category.Indicator -> RenderIndicator(type)
        Category.Section -> RenderSection(type)
        Category.Box -> RenderBox(type)
        Category.Counter -> RenderCounter(type)
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
        TTCardSelectorList -> TTCardSelectorListSection()
        TTCardCarouselText -> TTCardCarouselTextSection()
        TTCardCarouselTitle -> TTCardCarouselTitleSection()
        TTCardCarouselTitleElevated -> TTCardCarouselTitleElevatedSection()
        else -> error("Invalid Card type")
    }
}

@Composable
private fun RenderPicker(type: ComponentType) {
    when (type) {
        TTImageHorizontalPicker -> TTImageHorizontalPickerSection()
        TTImagePicker -> TTImagePickerSection()
        TTListPicker -> TTListPickerSection()
        TTCurrencyPicker -> TTCurrencyPickerSection()
        TTDatePicker -> TTDatePickerSection()
        else -> error("Invalid Picker type")
    }
}

@Composable
private fun RenderProgressBar(type: ComponentType) {
    when (type) {
        TTProgressBar -> TTProgressBarSection()
        else -> error("Invalid Progress Bar type")
    }
}

@Composable
private fun RenderPager(type: ComponentType) {
    when (type) {
        TTPager -> TTPagerSection()
        TTPagerIndicator -> TTPagerIndicatorSection()
        else -> error("Invalid Page type")
    }
}

@Composable
private fun RenderIndicator(type: ComponentType) {
    when (type) {
        TTStepperTextIndicator -> TTStepperTextIndicatorSection()
        else -> error("Invalid Indicator type")
    }
}

@Composable
private fun RenderBox(type: ComponentType) {
    when (type) {
        SocialBox -> TTSocialBoxSection()
        else -> error("Invalid Indicator type")
    }
}

@Composable
private fun RenderCounter(type: ComponentType) {
    when (type) {
        ComponentType.Counter -> TTCounterSection()
        else -> error("Invalid Indicator type")
    }
}

@Composable
private fun RenderSection(type: ComponentType) {
    when (type) {
        TTBullet -> TTBulletSection()
        TTImageCardHeader -> TTImageCardHeaderSection()
        TTImageFull -> TTImageFullSection()
        TTInfo -> TTInfoSection()
        TTParagraph -> TTParagraphSection()
        TTUserImage -> TTUserImageSection()
        else -> error("Invalid Section type")
    }
}
