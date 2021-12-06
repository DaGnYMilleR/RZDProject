package filters

import IParameters
import models.Journey

interface IFilter {
    fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey>
}