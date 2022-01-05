package filters

import Parameters
import models.Journey


interface IFilter {
    fun filter(journeys: List<Journey>, parameters: Parameters): List<Journey>
}