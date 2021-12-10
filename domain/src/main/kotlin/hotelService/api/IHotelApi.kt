package hotelService.api

import models.City
import models.DateSegment
import org.springframework.stereotype.Component

@Component
interface IHotelApi {
    fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse>
}