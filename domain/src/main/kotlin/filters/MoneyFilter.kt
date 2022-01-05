package filters

import Parameters
import models.Journey


class MoneyFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: Parameters): List<Journey> {
        return journeys.map { journey ->
            Journey(
                journey.city,
                journey.tickets,
                journey.hotels.filter { it.price <= parameters.trainsBudget }
            )
        }
    }
}