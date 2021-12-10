package hotelService

import models.City
import models.DateSegment

data class HotelServiceParams(val city: City, val journeyDuration: DateSegment)