package hotelService

import models.City
import models.DateSegment

class HotelServiceParams(override val city: City, override val journeyDuration: DateSegment) : IHotelServiceParams {
}