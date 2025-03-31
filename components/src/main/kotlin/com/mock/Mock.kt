package com.mock

import com.components.cardcarousel.model.TTCardCarouselTitleItem
import com.domain.model.*
import com.domain.model.RestaurantSectionModel.RestaurantMenu
import com.domain.model.SectionModel.InfoSection.InfoBox
import com.domain.model.SectionModel.ParagraphSection.Paragraph
import com.ttcomponents.app.R
import kotlinx.collections.immutable.persistentListOf

const val titleMock = "This is a title"
const val textMock =
    "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno."
const val textLongMock =
    "Desde los rincones más pintorescos hasta los tesoros ocultos de cada ciudad, esta guía es un compendio de descubrimientos que te invitará a sumergirte en nuevas culturas y conectar con la autenticidad de cada destino. ¿Te apasiona probar sabores locales, explorar mercados vibrantes o simplemente perderte en las calles encantadoras de un lugar desconocido? Aquí encontrarás ideas para todos los gustos.\n\nNo se trata solo de mis experiencias, sino de proporcionarte la inspiración y la información para que crees tu propia historia de viaje única. Prepárate para embarcarte en una aventura llena de sorpresas y momentos inolvidables. ¡Descubre, vive y crea tu propia guía de viajes personalizada!"
const val imageMock = "https://capasdelatierra.win/wp-content/uploads/paisajes-naturales.jpg"
const val imageBase64Mock = "R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs="
const val addressMock = "Calle de Prueba 27, 32908 (Madrid)"
const val acceptMock = "Aceptar"
const val cancelMock = "Cancelar"
const val buttonMock = "Button"
val imageModelMock = GuideModel.ImageModel(imageUrl = imageMock)
val menuMock = listOf(
    RestaurantMenu(
        id = "1",
        name = textMock,
        price = 10
    ),
    RestaurantMenu(
        id = "2",
        name = "Name",
        price = 10
    ),
    RestaurantMenu(
        id = "3",
        name = "Name",
        price = 10
    )
)

val destinationMock = listOf(
    TTCardCarouselTitleItem(
        id = 1,
        title = "España",
        image = R.drawable.country
    ),
    TTCardCarouselTitleItem(
        id = 1,
        title = "Reino Unido",
        image = R.drawable.uk
    ),
    TTCardCarouselTitleItem(
        id = 1,
        title = "Italia",
        image = R.drawable.italia
    ),
    TTCardCarouselTitleItem(
        id = 1,
        title = "Australia",
        image = R.drawable.country
    )
)

val guideMock = GuideModel(
    id = "0",
    title = "Guía por España",
    description = textLongMock,
    image = GuideModel.ImageModel(imageUrl = imageMock),
    totalLikes = 100000,
    totalSaves = 9323,
    tabs = listOf(
        TabModel(
            sections = listOf(
                Paragraph(
                    model = ParagraphSectionModel(
                        title = titleMock,
                        text = textLongMock
                    )
                ),
                InfoBox(
                    model = InfoSectionModel(
                        title = titleMock,
                        text = textLongMock
                    )
                ),
                Paragraph(
                    model = ParagraphSectionModel(
                        title = titleMock,
                        text = textLongMock
                    )
                )
            )
        )
    )
)

val restaurantPriceMock = RestaurantPriceModel(
    id = 1,
    value = "1"
)

val restaurantRateMock = RestaurantRateModel(
    id = 1,
    value = "2"
)