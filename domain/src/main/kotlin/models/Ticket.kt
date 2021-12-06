package models

class Ticket(
    val cityFrom: City,
    val cityTo: City,
    val cost: Double,
    val travellingTime: TravellingTime
) {

}