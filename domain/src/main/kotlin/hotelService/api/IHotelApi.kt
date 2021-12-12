package hotelService.api

import models.City
import models.DateSegment


interface IHotelApi {
    fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse>
}