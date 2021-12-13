package rzdService.api

import models.City
import models.DateSegment
import models.Ticket
import rzdService.api.IRzdApi as IRzdApi1

class RzdApi : IRzdApi1 {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Ticket {
        TODO("Not yet implemented")
    }
}

