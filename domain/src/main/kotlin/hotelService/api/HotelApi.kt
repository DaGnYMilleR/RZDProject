package hotelService.api

import HttpService
import models.City
import models.DateSegment
import org.springframework.stereotype.Component

@Component
class HotelApi(val httpService: HttpService) : IHotelApi {
    private val hotelsCount = 5
    private val apiUrl = "http://engine.hotellook.com/api/v2/cache.json?location=%s" +
                    "&currency=rub&checkIn=%s&checkOut=%s&limit=$hotelsCount"

    override fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse> {
        return httpService.getResponse(
            java.lang.String.format(apiUrl, destinationCity.name, journeyDuration.start, journeyDuration.end));
    }
}


