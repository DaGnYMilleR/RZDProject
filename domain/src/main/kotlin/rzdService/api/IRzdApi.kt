package rzdService.api

import models.City
import models.DateSegment
import models.Ticket


interface IRzdApi {
    fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Ticket
}

