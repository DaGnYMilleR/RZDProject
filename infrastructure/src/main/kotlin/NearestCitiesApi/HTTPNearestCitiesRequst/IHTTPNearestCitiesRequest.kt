package NearestCitiesApi.HTTPNearestCitiesRequst

import City
import NearestCitiesApi.NearestCitiesResponse.INearestCitiesResponse

interface IHTTPNearestCitiesRequest {
    fun request(city: City, distance: Int): INearestCitiesResponse
}