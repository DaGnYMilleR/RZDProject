package hotelService.api

import models.City
import models.DateSegment
import hotelService.responce.IHotelResponse

interface IHotelApi {
    fun makeRequest(city: City, journeyDuration: DateSegment): IHotelResponse
}