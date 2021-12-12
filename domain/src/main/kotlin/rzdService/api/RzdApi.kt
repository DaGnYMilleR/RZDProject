package rzdService.api

import models.City
import models.DateSegment
import rzdService.response.IRzdResponse

class RzdApi : IRzdApi {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): IRzdResponse {
        TODO("Not yet implemented")
    }
}