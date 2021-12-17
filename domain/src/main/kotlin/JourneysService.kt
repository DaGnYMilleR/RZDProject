import citiesRepository.ICitiesRepository
import filters.ICompositeFilter
import hotelService.HotelServiceParams
import hotelService.IHotelService
import models.City
import models.DateSegment
import models.Journey
import models.TravellingTime
import rzdService.IRzdService
import rzdService.RzdParams
import kotlin.streams.toList

class JourneysService(
    private val citiesRepository: ICitiesRepository,
    private val rzdService: IRzdService,
    private val hotelService: IHotelService,
    private val compositeFilter: ICompositeFilter
) {
    fun getJourneys(parameters: IParameters): List<Journey> {
        val currentCity = citiesRepository.getCityByName(parameters.city.name)
        val availableCities = citiesRepository
            .getCitiesByTags(parameters.tags, 5)
            .minusElement(currentCity)

        val journeys = availableCities.parallelStream()
            .map { createJourney(parameters.city, it, parameters.journeyDuration) }
            .toList()

        return compositeFilter.filter(journeys, parameters)
    }

    private fun createJourney(cityFrom: City, cityTo: City, journeyDuration: DateSegment): Journey  {
        val tickets = rzdService.getTicket(RzdParams(cityFrom, cityTo, journeyDuration))
        val date = getTimeOfStayInCity(tickets.first().travellingTime)
        val hotels = hotelService.getHotels(HotelServiceParams(cityTo, date, 20000.0))
        return Journey(cityTo, tickets.first(), hotels)
    }

    private fun getTimeOfStayInCity(travellingTime: TravellingTime): DateSegment {
        return DateSegment(travellingTime.toPlace.end, travellingTime.fromPlace.start)
    }
}




