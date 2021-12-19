package filters

import IParameters
import models.Journey


class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        return journeys.map { journey ->
            Journey(
                journey.city,
                journey.tickets,
                journey.hotels.filter { it.price <= parameters.money }
            )
        }
    }
}