package rzdService.api

import models.*
import rzdService.response.IRzdResponse
import java.time.LocalDate
import rzdService.api.IRzdApi as IRzdApi1

class RzdApi : IRzdApi1 {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Ticket {
        TODO("Not yet implemented")
    }
}

class MockedRzdApi : IRzdApi1{
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Ticket {
        val time = LocalDate.of(2021, 12, 12)
        val time2 = LocalDate.of(2021, 12, 30)
        return Ticket(
            City("Yekaterinburg", listOf(), listOf()),
            City("Sochi", listOf(), listOf()),
            1000.0,
           TravellingTime(DateSegment(time, time.plusDays(1)), DateSegment(time2, time2.plusDays(1))))
    }
}