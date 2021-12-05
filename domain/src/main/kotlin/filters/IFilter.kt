package filters

import Journey

interface IFilter {
    fun filter(journeys: List<Journey>): List<Journey>
}