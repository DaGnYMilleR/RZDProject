package filters

import IParameters
import models.Journey

class BadJourneyFilter : IFilter{
    override fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey> =
        journeys.filter { it.tickets.isNotEmpty() }
}