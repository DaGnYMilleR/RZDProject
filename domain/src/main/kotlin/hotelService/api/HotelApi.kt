package hotelService.api

import HttpService
import models.City
import models.DateSegment


class HotelApi(private val httpService: HttpService) : IHotelApi {
    private val apiUrl = "http://engine.hotellook.com/api/v2/cache.json?location=%s" +
            "&currency=rub&checkIn=%s&checkOut=%s&limit=%s"

    override fun makeRequest(
        destinationCity: City,
        journeyDuration: DateSegment,
        hotelsCount: Int
    ): Array<HotelResponse> {

        return httpService.getResponse(
            String.format(apiUrl, destinationCity.name, journeyDuration.start, journeyDuration.end, hotelsCount)
        )
    }
}