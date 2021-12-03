package NearestCitiesApi.HTTPNearestCitiesRequst

import City
//http://htmlweb.ru/api/geo/city_coming/?city_coming=1&api_key=API_KEY_из_профиля
class HTTPNearestCitiesRequest : IHTTPNearestCitiesRequest {
    override fun request(city: City, distance: Int): String {
        TODO("Not yet implemented")
    }
}