package rzdService.api

import HttpService
import models.City
import models.DateSegment
import models.Ticket
import models.TravellingTime
import java.time.LocalDate
import rzdService.api.IRzdApi as IRzdApi1

class RzdApi(private val httpService: HttpService) : IRzdApi1 {
    override fun request(cityFrom: City, cityTo: City, journeyDuration: DateSegment, cost: Double): List<Ticket> {
        val dayStartTraveling = journeyDuration.start
        val dayEndTraveling = journeyDuration.end
        var listTickets = listOf<Ticket>()
        cityFrom.stationsId.forEach first@{ idFrom ->
            cityTo.stationsId.forEach { idTo ->
                run {
                    val ticketsTo = getResponse(idFrom, idTo, dayStartTraveling)?.filter { x -> x.categories.first().type == "plazcard" }
                    if (ticketsTo != null && listTickets.isEmpty() && ticketsTo.isNotEmpty()) {
                        val timeTraveling = getCountDaysTravel(ticketsTo.first().travelTimeInSeconds.toInt())
                        val dayArrivalTo = dayStartTraveling.plusDays(timeTraveling.toLong())
                        val ticketsFrom = getResponse(idTo, idFrom, dayStartTraveling.minusDays(timeTraveling.toLong()))?.filter { x -> x.categories.first().type == "plazcard" }

                        if (ticketsFrom != null && ticketsFrom.isNotEmpty()) {
                            val priceTravelFrom = ticketsFrom.map { it.categories.first().price }.first()
                            val priceTravelTo = ticketsTo.map { it.categories.first().price }.first()
                            val dayToSendHome = dayEndTraveling.minusDays(timeTraveling.toLong())
                            if (priceTravelFrom + priceTravelTo < cost) {
                                listTickets = ticketsTo.map {
                                    Ticket(
                                        cityFrom,
                                        cityTo,
                                        it.categories.first().price + priceTravelFrom,
                                        TravellingTime(
                                            DateSegment(dayStartTraveling, dayArrivalTo),
                                            DateSegment(dayToSendHome, dayEndTraveling)
                                        ),
                                        createUrlToBuyTicket(idTo, idFrom, dayStartTraveling, it.numberForUrl),
                                        createUrlToBuyTicket(
                                            idFrom,
                                            idTo,
                                            dayEndTraveling,
                                            ticketsFrom.first().numberForUrl
                                        )
                                    )
                                }

                                return@first
                            }
                        }
                    }
                }
            }
        }
        return listTickets
    }

    private fun getCountDaysTravel(seconds : Int): Int = seconds / 60 / 60 / 24

    private fun createUrlToBuyTicket(idTo: Int, idFrom: Int, date: LocalDate, numberForUrl: String): String =
        "https://www.tutu.ru/poezda/order/?dep_st=$idFrom&arr_st=$idTo&tn=$numberForUrl%3D&date=$date"


    private fun getResponse(idTo: Int, idFrom: Int, date: LocalDate): List<Trip>? {
        val url = getUlrWithParameters(idFrom, idTo, date)
        return httpService.getResponse<RzdResponse>(url)?.trips
    }

    private fun getUlrWithParameters(idTo: Int, idFrom: Int, date: LocalDate): String =
        "https://suggest.travelpayouts.com/search?service=tutu_trains&term=${idTo}&term2=${idFrom}&date=${date}"
}