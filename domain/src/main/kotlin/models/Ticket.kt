package models

data class Ticket(
    val cityFrom: City,
    val cityTo: City,
    val cost: Double,
    val travellingTime: TravellingTime,
    val urlTo: String,
    val urlFrom: String
)
