package filters

import Parameters
import models.Journey


class CompositeFilter(private val filters: List<IFilter>) : ICompositeFilter {
    override fun filter(journeys: List<Journey>, parameters: Parameters): List<Journey> {
        var filteredJourneys = journeys
        for (filter in filters) {
            filteredJourneys = filter.filter(filteredJourneys, parameters)
        }

        return filteredJourneys
    }
}