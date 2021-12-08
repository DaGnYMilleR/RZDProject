package hotelService.api

import hotelService.responce.HotelResponse
import hotelService.responce.IHotelResponse
import models.City
import models.DateSegment
import okhttp3.*
import org.springframework.stereotype.Component


@Component
class HotelApi : IHotelApi {
    private val client = OkHttpClient()

    override fun makeRequest(city: City, journeyDuration: DateSegment): IHotelResponse {
        return HotelResponse()
    }
}
