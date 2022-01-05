package filters

import Parameters
import models.Journey


interface ICompositeFilter {
    fun filter(journeys: List<Journey>, parameters: Parameters): List<Journey>
}