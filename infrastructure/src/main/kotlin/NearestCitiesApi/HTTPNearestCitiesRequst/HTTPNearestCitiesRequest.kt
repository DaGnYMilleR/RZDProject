package NearestCitiesApi.HTTPNearestCitiesRequst

import City
import NearestCitiesApi.NearestCitiesResponse.INearestCitiesResponse

//http://htmlweb.ru/api/geo/city_coming/?city_coming=1&api_key=API_KEY_из_профиля
class HTTPNearestCitiesRequest : IHTTPNearestCitiesRequest {
    override fun request(city: City, distance: Int): INearestCitiesResponse {
        TODO("Not yet implemented")
    }
}