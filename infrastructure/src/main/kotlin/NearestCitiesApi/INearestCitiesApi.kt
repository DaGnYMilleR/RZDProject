package NearestCitiesApi

import City

interface INearestCitiesApi {
    fun getNearestCities(city: City, distance: Int): List<City>;
}