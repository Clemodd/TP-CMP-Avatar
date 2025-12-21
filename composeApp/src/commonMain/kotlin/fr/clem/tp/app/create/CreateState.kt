package fr.clem.tp.app.create

data class CreateState(
    val title: String = "",
    val description: String = "",
    val image: UiImage? = null,
    val isValid: Boolean = false
)