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
        cityFrom.stationsId.forEach { idFrom ->
            cityTo.stationsId.forEach { idTo ->
                run {
                    val url = "https://suggest.travelpayouts.com/search?service=" +
                            "tutu_trains&term=${idFrom}&term2=${idTo}&date=${journeyDuration.start}"
                    val tickets = httpService.getResponse<RzdResponse>(url)?.trips
                    if (tickets != null && res.isNotEmpty())
                        res = tickets.map {
                            Ticket(
                                cityFrom,
                                cityTo,
                                it.categories.first().price,
                                TravellingTime(
                                    DateSegment(time, time.plusDays(1)),
                                    DateSegment(time2.minusDays(1), time2)
                                )
                            )
                        }
                }
            }
        }
        return res
    }
}