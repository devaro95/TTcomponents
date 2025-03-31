package com.model

import com.example.tt_components.R

enum class ComponentType(val value: String, val category: Category) {
    // Buttons
    AXButton("Button", Category.Button),
    AXButtonIconSquare("ButtonIconSquare", Category.Button),
    AXButtonSave("ButtonSave", Category.Button),
    AXButtonSecondary("ButtonSecondary", Category.Button),
    AXFloatingButton("FloatingButton", Category.Button),

    // Inputs
    AXInput("Input", Category.Input),
    AXInputClickableDropdown("InputClickableDropdown", Category.Input),
    AXInputCurrency("InputCurrency", Category.Input),
    AXInputCurrencyPicker("InputCurrencyPicker", Category.Input),
    AXInputDate("InputDate", Category.Input),
    AXInputDropdown("InputDropdown", Category.Input),
    AXInputMenuDropdown("InputMenuDropdown", Category.Input),
    AXInputPassword("InputPassword", Category.Input),

    // Carousel
    AXIconCarousel("Icon Carousel", Category.Carousel),
    AXIconCardCarousel("Icon Card Carousel", Category.Carousel),

    // Menus
    AXMenu("Menu", Category.Menu),
    AXMenuRounded("Menu Rounded", Category.Menu),

    // Cards
    TTCardImage("Card Add Image", Category.Card),
    TTCardImageCarousel("Card Add Image Carousel", Category.Card),
    TTCardSocial("Card Social", Category.Card),
    TTCardSocialTwo("Card Social Two", Category.Card),
    TTCardSelector("Card Selector", Category.Card),
    TTCardSelectorList("Card Selector List", Category.Card),
    TTCardCarouselText("Card Carousel Text", Category.Card),
    TTCardCarouselTitle("Card Carousel Title", Category.Card),
    TTCardCarouselTitleElevated("Card Carousel Title Elevated", Category.Card),

    // Picker
    TTImageHorizontalPicker("Image Horizontal Picker", Category.Picker),
    TTImagePicker("Image Picker", Category.Picker),
    TTListPicker("List Picker", Category.Picker),
    TTCurrencyPicker("Currency Picker", Category.Picker),
    TTDatePicker("Date Picker", Category.Picker),

    //Progress Bar
    TTProgressBar("Progress Bar", Category.Progress),

    //Pager
    TTPager("Pager", Category.Pager),
    TTPagerIndicator("Pager Indicator", Category.Pager),

    //Indicator
    AXStepperTextIndicator("Stepper Text Indicator", Category.Indicator),
    AXStepperIndicator("Stepper Indicator", Category.Indicator),

    //Box
    SocialBox("Social Box", Category.Box),

    //Counter
    AXCounter("Counter", Category.Counter),

    // Sections
    TTBullet("Bullet", Category.Section),
    TTParagraph("Paragraph", Category.Section),
    TTImageFull("Image Full", Category.Section),
    TTInfo("Info", Category.Section),
    TTUserImage("User Image", Category.Section),
    TTImageCardHeader("Image Card Header", Category.Section);


    enum class Category(val title: String, val icon: Int) {
        Button(title = "Buttons", icon = R.drawable.ic_button),
        Input(title = "Inputs", icon = R.drawable.ic_input),
        Menu(title = "Menus", icon = R.drawable.ic_menu),
        Card(title = "Cards", icon = R.drawable.ic_card),
        Picker(title = "Picker", icon = R.drawable.ic_picker),
        Progress(title = "ProgressBar", icon = R.drawable.ic_progress),
        Pager(title = "Pager", icon = R.drawable.ic_pager),
        Indicator(title = "Indicator", icon = R.drawable.ic_indicator),
        Box(title = "Sections", icon = R.drawable.ic_button),
        Counter(title = "Counter", icon = R.drawable.ic_button),
        Section(title = "Box", icon = R.drawable.ic_button),
        Carousel(title = "Carousel", icon = R.drawable.ic_button),
    }
}
