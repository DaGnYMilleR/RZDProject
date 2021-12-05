import database.Database
import filters.MoneyFilter
import filters.PlaceFilter
import hotelService.HotelService
import hotelService.HotelServiceParams
import rzdService.RZDService
import rzdService.RzdParams

class MainClass(private val dataBase: Database, private val rzdService: RZDService, private val hotelService: HotelService) {
    fun mainMethod(params: IParams) {
        val availableCities = dataBase.getCitiesByTags(params.tags)

        val journeys = availableCities
            .map { city -> getJourney(params.city, city, params.tripDuration) }

        val filters = listOf(MoneyFilter(), PlaceFilter())

        var filteredJourneys = filters.flatMap { it.filter(journeys) }
    }

    private fun getJourney(cityFrom: City, cityTo: City, tripDuration: DateSegment): Journey {
        val ticket = rzdService.getTrip(RzdParams(cityFrom, cityTo, tripDuration))
        val date = getTimeOfStayInCity(ticket.travellingTime)
        val hotels = hotelService.getHotels(HotelServiceParams(cityTo, date))
        return Journey(cityTo, ticket, hotels)
    }

    private fun getTimeOfStayInCity(travellingTime: TravellingTime): DateSegment {
        return DateSegment(travellingTime.fromPlace.end, travellingTime.toPlace.start)
    }
}




