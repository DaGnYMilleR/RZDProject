package hotelService.api

import models.City
import models.DateSegment
import hotelService.responce.IHotelResponse

interface IHotelApi {
    fun makeRequest(destinationCity: City, journeyDuration: DateSegment): HotelResponse2
}