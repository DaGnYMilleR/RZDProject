package NearestCitiesApi

import City
import NearestCitiesApi.HTTPNearestCitiesRequst.IHTTPNearestCitiesRequest
import NearestCitiesApi.NearestCitiesParser.INearestCitiesParser

class NearestCitiesApi(private val httpNearestCitiesRequest: IHTTPNearestCitiesRequest,
                       private val nearestCitiesParser: INearestCitiesParser) : INearestCitiesApi {
    override fun getNearestCities(city: City, distance: Int): List<City> {
        val request = httpNearestCitiesRequest.request(city, distance);
        val cities = nearestCitiesParser.parse(request);
        return cities;
    }
}