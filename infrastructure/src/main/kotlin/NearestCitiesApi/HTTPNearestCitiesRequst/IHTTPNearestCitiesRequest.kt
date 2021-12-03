package NearestCitiesApi.HTTPNearestCitiesRequst

import City

interface IHTTPNearestCitiesRequest {
    fun request(city: City, distance: Int): String
}