package filters

import IParameters
import models.Journey
import org.springframework.stereotype.Component

@Component
interface ICompositeFilter {
    fun filter(journeys: List<Journey>, parameters: IParameters): List<Journey>
}