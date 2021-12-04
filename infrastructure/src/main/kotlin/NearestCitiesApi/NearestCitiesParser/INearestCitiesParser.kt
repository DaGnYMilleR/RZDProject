package NearestCitiesApi.NearestCitiesParser

import City
import NearestCitiesApi.NearestCitiesResponse.INearestCitiesResponse

interface INearestCitiesParser {
    fun parse(response: INearestCitiesResponse): List<City>
}