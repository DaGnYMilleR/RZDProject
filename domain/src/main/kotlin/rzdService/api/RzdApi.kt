package rzdService.api

import HttpService
import models.City
import models.DateSegment
import models.Ticket
import models.TravellingTime
import rzdService.api.IRzdApi as IRzdApi1

class RzdApi(private val httpService: HttpService) : IRzdApi1 {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment): List<Ticket> {
        val time = journeyDuration.start
        val time2 = journeyDuration.end
        var res = listOf<Ticket>()
        cityFrom.stationsId.forEach first@{ idFrom ->
            cityTo.stationsId.forEach { idTo ->
                run {
                    val urlTo = "https://suggest.travelpayouts.com/search?service=" +
                            "tutu_trains&term=${idFrom}&term2=${idTo}&date=${time}"
                    val urlFrom = "https://suggest.travelpayouts.com/search?service=" +
                            "tutu_trains&term=${idTo}&term2=${idFrom}&date=${time2}"
                    val ticketsTo = httpService.getResponse<RzdResponse>(urlTo)?.trips
                    val ticketsFrom = httpService.getResponse<RzdResponse>(urlFrom)?.trips
                    if (ticketsTo != null && res.isEmpty() && ticketsTo.isNotEmpty() && ticketsFrom != null && ticketsFrom.isNotEmpty()) {
                        val price2 = ticketsFrom.map { it.categories.first().price }.first()
                        res = ticketsTo.map {
                            Ticket(
                                cityFrom,
                                cityTo,
                                it.categories.first().price +  price2,
                                TravellingTime(
                                    DateSegment(time, time.plusDays(1)),
                                    DateSegment(time2.minusDays(1), time2)
                                )
                            )
                        }
                        return@first
    }
                    }
                }
            }
        return res
    }
}