package hotelService.api

import models.City
import models.DateSegment
import hotelService.responce.IHotelResponse
import org.springframework.stereotype.Component

@Component
interface IHotelApi {
    fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse2>
}