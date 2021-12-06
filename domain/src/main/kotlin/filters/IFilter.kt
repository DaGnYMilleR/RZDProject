package filters

import models.Journey

interface IFilter {
    fun filter(journeys: List<Journey>): List<Journey>
}