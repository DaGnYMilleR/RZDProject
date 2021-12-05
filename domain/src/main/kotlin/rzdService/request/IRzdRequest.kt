package rzdService.request

import City
import DateSegment
import rzdService.response.IRzdResponse

interface IRzdRequest {
    fun request(cityFrom: City, cityTo: City, tripDuration: DateSegment): IRzdResponse
}

