package com.render

import androidx.compose.runtime.Composable
import com.model.ComponentType
import com.model.ComponentType.*
import com.sections.box.TTSocialBoxSection
import com.sections.button.*
import com.sections.card.*
import com.sections.carousel.AXIconCardCarouselSection
import com.sections.carousel.AXIconCarouselSection
import com.sections.counter.AXCounterSection
import com.sections.guideSection.bullet.TTBulletSection
import com.sections.guideSection.image.*
import com.sections.guideSection.indicator.AXStepperIndicatorSection
import com.sections.guideSection.indicator.AXStepperTextIndicatorSection
import com.sections.guideSection.info.TTInfoSection
import com.sections.guideSection.paragraph.TTParagraphSection
import com.sections.input.*
import com.sections.menu.AXMenuRoundedSection
import com.sections.menu.AXMenuSection
import com.sections.pager.TTPagerIndicatorSection
import com.sections.pager.TTPagerSection
import com.sections.picker.*
import com.sections.progress.TTProgressBarSection

@Composable
fun RenderSections(type: ComponentType) {
    when (type.category) {
        Category.Button -> RenderAXButton(type)
        Category.Input -> RenderAXInput(type)
        Category.Carousel -> RenderAXCarousel(type)
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
private fun RenderAXButton(type: ComponentType) {
    when (type) {
        AXButton -> AXButtonSection()
        AXButtonIconSquare -> AXButtonIconSquareSection()
        AXButtonSave -> AXButtonSaveSection()
        AXButtonSecondary -> AXButtonSecondarySection()
        AXFloatingButton -> AXFloatingButtonSection()
        else -> error("Invalid Button type")
    }
}

@Composable
private fun RenderAXInput(type: ComponentType) {
    when (type) {
        AXInput -> AXInputSection()
        AXInputClickableDropdown -> AXInputClickableDropdownSection()
        AXInputCurrency -> AXInputCurrencySection()
        AXInputCurrencyPicker -> AXInputCurrencyPickerSection()
        AXInputDate -> AXInputDateSection()
        AXInputDropdown -> AXInputDropdownSection()
        AXInputMenuDropdown -> AXInputMenuDropdownSection()
        AXInputPassword -> AXInputPasswordSection()
        else -> error("Invalid Input type")
    }
}

@Composable
private fun RenderAXCarousel(type: ComponentType) {
    when (type) {
        AXIconCarousel -> AXIconCarouselSection()
        AXIconCardCarousel -> AXIconCardCarouselSection()
        else -> error("Invalid Section type")
    }
}

@Composable
private fun RenderMenu(type: ComponentType) {
    when (type) {
        AXMenu -> AXMenuSection()
        AXMenuRounded -> AXMenuRoundedSection()
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
        AXStepperIndicator -> AXStepperIndicatorSection()
        AXStepperTextIndicator -> AXStepperTextIndicatorSection()
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
        AXCounter -> AXCounterSection()
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
