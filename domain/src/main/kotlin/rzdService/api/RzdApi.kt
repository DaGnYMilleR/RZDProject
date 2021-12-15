package rzdService.api

import HttpService
import models.City
import models.DateSegment
import models.Ticket
import models.TravellingTime
import rzdService.api.IRzdApi as IRzdApi1

class RzdApi(private val httpService: HttpService) : IRzdApi1 {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): List<Ticket> {
        val urlTo = "https://suggest.travelpayouts.com/search?service=" +
                    "tutu_trains&term=${cityFrom.stationsId.first()}&" +
                    "term2=${cityTo.stationsId.first()}&date=${journeyDuration.start}"
        val tickets = httpService.getResponse<RzdResponse>(urlTo).trips
        val time = journeyDuration.start
        val time2 = journeyDuration.end
        return tickets
            .map {
                Ticket(
                    cityFrom,
                    cityTo,
                    it.categories.first().price,
                    TravellingTime(DateSegment(time, time.plusDays(1)), DateSegment(time2.minusDays(1), time2)))
            }
    }
}