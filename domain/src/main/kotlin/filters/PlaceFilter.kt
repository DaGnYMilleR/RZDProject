package filters

import IParameters
import models.Journey
import org.springframework.stereotype.Component

@Component
class PlaceFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        val tags = parameters.tags.toSet()
        return journeys.sortedBy {
            journey -> tags.intersect(journey.city.tags.toSet()).count()
        }.reversed()
    }
}