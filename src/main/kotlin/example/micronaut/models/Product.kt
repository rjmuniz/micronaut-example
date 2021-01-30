package example.micronaut.models

class Product(
    val id: Int,
    val name: String,
    val description: String = "---"
)