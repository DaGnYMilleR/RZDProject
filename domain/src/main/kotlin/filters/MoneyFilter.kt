package filters

import models.Journey

class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>): List<Journey> {
        journeys.stream().forEach { x -> x.hotels.stream().filter { y -> y.price + x.ticket.cost <= 20000 } }
        return journeys
    }

    fun filter(journeys: List<Journey>, cost: Double): List<Journey> {
        journeys.stream().forEach{ x -> x.hotels.stream().filter { y -> y.price + x.ticket.cost <= cost } }
        return journeys
    }
}