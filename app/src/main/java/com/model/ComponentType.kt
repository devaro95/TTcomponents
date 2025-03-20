package com.model

enum class ComponentType(val value: String, val category: Category) {
    // Buttons
    TTButton("Button", Category.Button),
    TTButtonIconSquare("ButtonIconSquare", Category.Button),
    TTButtonSave("ButtonSave", Category.Button),
    TTButtonSecondary("ButtonSecondary", Category.Button),
    TTFloatingButton("FloatingButton", Category.Button),

    // Inputs
    TTInput("Input", Category.Input),
    TTInputClickableDropdown("InputClickableDropdown", Category.Input),
    TTInputCurrency("InputCurrency", Category.Input),
    TTInputCurrencyPicker("InputCurrencyPicker", Category.Input),
    TTInputDate("InputDate", Category.Input),
    TTInputDropdown("InputDropdown", Category.Input),
    TTInputMenuDropdown("InputMenuDropdown", Category.Input),
    TTInputPassword("InputPassword", Category.Input),

    // Menus
    TTMenu("Menu", Category.Menu),
    TTMenuRounded("Menu Rounded", Category.Menu),

    // Cards
    TTCardImage("Card Add Image", Category.Card),
    TTCardImageCarousel("Card Add Image Carousel", Category.Card),
    TTCardSocial("Card Social", Category.Card),
    TTCardSocialTwo("Card Social Two", Category.Card),
    TTCardSelector("Card Selector", Category.Card),

    // Sections
    TTBullet("Bullet", Category.Section),
    TTParagraph("Paragraph", Category.Section),
    TTImageFull("Image Full", Category.Section),
    TTInfo("Info", Category.Section),
    TTUserImage("User Image", Category.Section),
    TTImageCardHeader("Image Card Header", Category.Section),
    TTPagerIndicator("Pager Indicator", Category.Section);

    enum class Category {
        Button, Input, Menu, Card, Section
    }

    companion object {
        fun componentsOf(category: Category): List<ComponentType> =
            entries.filter { it.category == category }
    }
}