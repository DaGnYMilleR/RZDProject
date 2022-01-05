package filters

import Parameters
import models.Journey

class BadJourneyFilter : IFilter{
    override fun filter(journeys: List<Journey>, parameters: Parameters): List<Journey> =
        journeys.filter { it.tickets.isNotEmpty() }
}