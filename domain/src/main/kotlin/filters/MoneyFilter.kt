package filters

import IParameters
import models.Journey


class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        return journeys.map { journey ->
            Journey(
                journey.city,
                journey.ticket,
                journey.hotels.filter { it.price + journey.ticket.cost <= parameters.money }
            )
        }
    }
}