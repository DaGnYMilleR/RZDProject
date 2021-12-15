package rzdService.api

import models.City
import models.DateSegment
import models.Ticket
import models.TravellingTime
import java.time.LocalDate

class MockedRzdApi : IRzdApi {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): List<Ticket> {
        val time = LocalDate.now()
        val time2 = time.plusWeeks(3)
        return listOf(
            Ticket(
                City("Yekaterinburg", listOf(), listOf()),
                City("Sochi", listOf(), listOf()),
                1000.0,
                TravellingTime(DateSegment(time, time.plusDays(1)), DateSegment(time2, time2.plusDays(1)))
            )
        )
    }
}