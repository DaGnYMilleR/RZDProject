package hotelService

import models.City
import models.DateSegment

interface IHotelServiceParams {
    val city: City
    val journeyDuration: DateSegment
}