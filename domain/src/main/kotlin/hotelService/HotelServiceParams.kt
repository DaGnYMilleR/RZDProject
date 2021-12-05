package hotelService

import City
import DateSegment

class HotelServiceParams(override val city: City, override val tripDuration: DateSegment) : IHotelServiceParams {
}