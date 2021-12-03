package NearestCitiesApi.NearestCitiesParser

import City

interface INearestCitiesParser {
    fun parse(response: String): List<City>
}