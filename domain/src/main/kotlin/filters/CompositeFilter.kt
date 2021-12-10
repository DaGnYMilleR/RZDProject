package filters

import IParameters
import models.Journey
import org.springframework.stereotype.Component

@Component
class CompositeFilter(private val filters: List<IFilter>) : ICompositeFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        var filteredJourneys = journeys
        for (filter in filters) {
            filteredJourneys = filter.filter(filteredJourneys, parameters)
        }

        return filteredJourneys
    }
}