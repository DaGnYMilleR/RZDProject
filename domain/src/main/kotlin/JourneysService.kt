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
import rzdService.TrainCarType
import kotlin.streams.toList

class JourneysService(
    private val citiesRepository: ICitiesRepository,
    private val rzdService: IRzdService,
    private val hotelService: IHotelService,
    private val compositeFilter: ICompositeFilter
) {
    fun getJourneys(parameters: Parameters): List<Journey> {
        val currentCity = citiesRepository.getCityByName(parameters.cityName)
        val availableCities = citiesRepository
            .getCitiesByTags(parameters.tags, 5)
            .minusElement(currentCity)

        val journeys = availableCities.parallelStream()
            .map { createJourney(currentCity, it, parameters.journeyDuration,
                parameters.trainsBudget, parameters.hotelsBudget, parameters.typeOfTrainCar) }
            .toList()

        return compositeFilter.filter(journeys, parameters)
    }

    private fun createJourney(cityFrom: City,
                              cityTo: City,
                              journeyDuration: DateSegment,
                              trainsBudget: Double,
                              hotelsBudget: Double?,
                              typeofTrainCar: TrainCarType
    ): Journey  {
        val tickets = rzdService.getTicket(RzdParams(cityFrom, cityTo, journeyDuration, trainsBudget, typeofTrainCar))
        if (tickets.isEmpty())
            return Journey(cityTo, tickets, listOf())
        val beingInCityTime = getTimeOfStayInCity(tickets.first().travellingTime)
        val hotels = if(hotelsBudget != null && hotelsBudget != .0)
            hotelService.getHotels(HotelServiceParams(cityTo, beingInCityTime, hotelsBudget)) else listOf()
        return Journey(cityTo, tickets, hotels)
    }

    private fun getTimeOfStayInCity(travellingTime: TravellingTime): DateSegment {
        return DateSegment(travellingTime.toPlace.end, travellingTime.fromPlace.start)
    }
}