package filters

import IParameters
import models.Journey


class PlaceFilter : IFilter {
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> {
        val tags = parameters.tags.toSet()
        return journeys.sortedBy { journey ->
            tags.intersect(journey.city.tags.toSet()).count()
        }.reversed()
    }
}