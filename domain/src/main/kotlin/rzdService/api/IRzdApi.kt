package rzdService.api

import models.City
import models.DateSegment
import rzdService.response.IRzdResponse

interface IRzdApi {
    fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): IRzdResponse
}

