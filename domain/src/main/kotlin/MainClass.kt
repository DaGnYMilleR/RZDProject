import citiesRepository.ICitiesRepository
import filters.MoneyFilter
import filters.PlaceFilter
import hotelService.HotelServiceParams
import hotelService.IHotelService
import models.City
import models.DateSegment
import models.Journey
import models.TravellingTime
import rzdService.IRZDService
import rzdService.RzdParams

class MainClass(private val citiesRepository: ICitiesRepository, private val rzdService: IRZDService, private val hotelService: IHotelService) {
    fun mainMethod(parameters: IParameters) {
        val availableCities = citiesRepository.getCitiesByTags(parameters.tags)

        val journeys = availableCities
            .map { city -> getJourney(parameters.city, city, parameters.journeyDuration) }

        val filters = listOf(MoneyFilter(), PlaceFilter())

        var filteredJourneys = filters.flatMap { it.filter(journeys) }
    }

    private fun getJourney(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Journey {
        val ticket = rzdService.getTicket(RzdParams(cityFrom, cityTo, journeyDuration))
        val date = getTimeOfStayInCity(ticket.travellingTime)
        val hotels = hotelService.getHotels(HotelServiceParams(cityTo, date))
        return Journey(cityTo, ticket, hotels)
    }

    private fun getTimeOfStayInCity(travellingTime: TravellingTime): DateSegment {
        return DateSegment(travellingTime.fromPlace.end, travellingTime.toPlace.start)
    }
}




