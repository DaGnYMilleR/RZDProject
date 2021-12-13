package filters

import IParameters
import models.Journey


class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        return journeys
            .onEach { journey ->
                journey.hotels.filter { hotel -> hotel.price + journey.ticket.cost <= parameters.money }
            }
    }
}