package filters

import models.Journey
import IParameters

class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        journeys.forEach { journey -> journey.hotels.stream().filter { hotel -> hotel.price + journey.ticket.cost <= parameters.money } }
        return journeys
    }
}