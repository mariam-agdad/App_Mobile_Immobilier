package ensa.android.immoapp.ui_components

enum class TopBardId {
    ANNONCES,
    FAVORIS,
    ACTIVITES,
    COMPTE,
    SERVICES
}

data class AlertFields(
    val typeOfComponent : String?,
    val label : String?,
    val options : List<String>? =null,
    val type : String? = null,
    val value : Any? = null
)

val alertFormFields = listOf<AlertFields>(
    AlertFields("switcher", "Est-il meublé ?"),
    AlertFields("switcher", "En colocation ?"),
    AlertFields("switcher", "Avec ascenseur ?"),
    AlertFields("button", "Type du bien", options = listOf<String>(
        "Maison",
        "Appartement",
        "Villa"
    )),
    AlertFields("button", "Type du service", options = listOf<String>(
        "service1",
        "service2",
        "service3"
    )),
    AlertFields("slider", "Surface habituelle", type = "surface"),
    AlertFields("slider", "Nombre des étages", type = "number"),
    AlertFields("slider", "Nombre des piéces", type = "number"),
    AlertFields("slider", "Votre budget", type = "currency"),
    AlertFields("dropDown", "Département", options = listOf<String>(
        "Marrakech, Gueliz",
        "Marrakech, Daoudiate"
    ))

    )

val alertFormFieldsFilledAlert1 = listOf<AlertFields>(
    AlertFields("switcher", "Est-il meublé ?", value = true),
    AlertFields("switcher", "En colocation ?", value = false),
    AlertFields("switcher", "Avec ascenseur ?", value = true),
    AlertFields("button", "Type du bien", options = listOf<String>(
        "Maison",
        "Appartement",
        "Villa"
    ), value = "Appartement"),
    AlertFields("button", "Type du service", options = listOf<String>(
        "Je veux louer mon bien",
        "Je veux vendre",
        "Je veux acheter",
        "Je veux louer un bien"
    ), value = "Je veux louer un bien"),
    AlertFields("slider", "Surface habituelle", type = "surface", value = (2f..50f)),
    AlertFields("slider", "Nombre des étages", type = "number", value = (2f..5f)),
    AlertFields("slider", "Nombre des piéces", type = "number", value = (2f..3f)),
    AlertFields("slider", "Votre budget", type = "price", value =(2f..1500f)),
    AlertFields("dropDown", "Département", options = listOf<String>(
        "Marrakech, Gueliz",
        "Marrakech, Daoudiate"
    ), value = "Marrakech, Daoudiate")

)

