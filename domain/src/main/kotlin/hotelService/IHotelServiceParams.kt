package hotelService

import City
import DateSegment

interface IHotelServiceParams {
    val city: City
    val tripDuration: DateSegment
}