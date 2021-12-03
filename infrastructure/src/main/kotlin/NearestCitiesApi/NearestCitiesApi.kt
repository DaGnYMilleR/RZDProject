package NearestCitiesApi

import City
import NearestCitiesApi.HTTPNearestCitiesRequst.HTTPNearestCitiesRequest
import NearestCitiesApi.NearestCitiesParser.NearestCitiesParser

class NearestCitiesApi : INearestCitiesApi {
    override fun getNearestCities(city: City, distance: Int): List<City> {
        val request = HTTPNearestCitiesRequest().request(city, distance);
        val cities = NearestCitiesParser().parse(request);
        return cities;
    }
}