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
        for (idFrom in cityFrom.stationsId){
            for (idTo in cityTo.stationsId){
                val ticketsTo = getResponse(idFrom, idTo, dayStartTraveling).filter { isPlazcard(it) }
                if (isTicketValid(ticketsTo)) {
                    val listTickets = getTickets(ticketsTo, idTo, idFrom, dayStartTraveling, dayEndTraveling, cityFrom, cityTo, cost)
                    if (listTickets.isNotEmpty())
                        return listTickets
                }
            }
        }
        return listOf<Ticket>()
    }

    private fun isTicketValid(ticket: List<Trip>?): Boolean = (ticket != null) && ticket.isNotEmpty()

    private fun isPlazcard(trip: Trip): Boolean = trip.categories.first().type == "plazcard"

    private fun getTickets(ticketsTo: List<Trip>, idTo: Int, idFrom: Int, dayStartTraveling: LocalDate,
                           dayEndTraveling: LocalDate, cityFrom: City, cityTo: City, cost: Double): List<Ticket> {
        val timeTraveling = getCountDaysTravel(ticketsTo.first().travelTimeInSeconds.toInt())
        val dayArrivalTo = dayStartTraveling.plusDays(timeTraveling.toLong())
        val dayToSendHome = dayEndTraveling.minusDays(timeTraveling.toLong())
        val ticketsFrom = getResponse(idTo, idFrom, dayToSendHome).filter { isPlazcard(it) }

        if (isTicketValid(ticketsFrom)) {

            val priceTravelFrom = ticketsFrom.map { it.categories.first().price }.maxOf { it }
            val priceTravelTo = ticketsTo.map { it.categories.first().price }.maxOf { it }
            println("$priceTravelFrom $priceTravelTo")
            if (priceTravelFrom + priceTravelTo < cost) {
                return createListTickets(
                    ticketsTo, ticketsFrom, cityTo, cityFrom,
                    priceTravelFrom, priceTravelTo, dayEndTraveling, dayStartTraveling, idFrom, idTo, dayArrivalTo, dayToSendHome
                )
            }
        }
        return listOf<Ticket>()
    }

    private fun createListTickets(ticketsTo: List<Trip>, ticketsFrom: List<Trip>, cityTo: City, cityFrom: City,
                                  priceTravelFrom: Double, priceTravelTo : Double,
                                  dayEndTraveling: LocalDate, dayStartTraveling: LocalDate, idFrom: Int, idTo: Int,
    dayArrivalTo: LocalDate, dayToSendHome: LocalDate): List<Ticket> {
        return mutableListOf<Ticket>(
        (
            Ticket(cityFrom, cityTo, priceTravelTo + priceTravelFrom,  TravellingTime(
                DateSegment(dayStartTraveling, dayArrivalTo),
                DateSegment(dayToSendHome, dayEndTraveling)
            ), createUrlToBuyTicket(idTo, idFrom, dayStartTraveling, ticketsTo.first().numberForUrl),
            createUrlToBuyTicket(
                idFrom,
                idTo,
                dayToSendHome,
                ticketsFrom.first().numberForUrl
            )
        )
        ))
    }

    private fun getCountDaysTravel(seconds : Int): Int = seconds / 60 / 60 / 24

    private fun createUrlToBuyTicket(idTo: Int, idFrom: Int, date: LocalDate, numberForUrl: String): String =
        "https://www.tutu.ru/poezda/order/?dep_st=$idFrom&arr_st=$idTo&tn=$numberForUrl%3D&date=$date"


    private fun getResponse(idTo: Int, idFrom: Int, date: LocalDate): List<Trip> {
        val url = getUlrWithParameters(idFrom, idTo, date)
        val trips = httpService.getResponse<RzdResponse>(url)?.trips
        return trips ?: emptyList()
    }

    private fun getUlrWithParameters(idTo: Int, idFrom: Int, date: LocalDate): String =
        "https://suggest.travelpayouts.com/search?service=tutu_trains&term=${idTo}&term2=${idFrom}&date=${date}"
}