package filters

import IParameters
import models.Journey


interface ICompositeFilter {
    fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey>
}