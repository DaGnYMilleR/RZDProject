package hotelService.api

import models.City
import models.DateSegment

class MockedHotelApi : IHotelApi {
    override fun makeRequest(destinationCity: City, journeyDuration: DateSegment, hotelsCount: Int): Array<HotelResponse> {
        val response = HotelResponse(
            Location("Country", GeoLocation(10f, 10f), "State", "Name"),
            100.0,
            HashMap(),
            "Hotel name",
            3,
            1,
            2,
            103.0
        )
        return arrayOf(response)
    }
}