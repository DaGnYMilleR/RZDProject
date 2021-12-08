package hotelService.api

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import models.City
import models.DateSegment
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Component




@Component
class HotelApi : IHotelApi {
    private val client = OkHttpClient()

    override fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse2> {
        val url = "http://engine.hotellook.com/api/v2/cache.json?location=${destinationCity.name}" +
                "&currency=rub&checkIn=${journeyDuration.start}&checkOut=${journeyDuration.end}&limit=20"
        val request = Request.Builder()
            .url(url)
            .build()
        return Json.decodeFromString(call(url).body!!.string())
    }

    fun call(url: String): Response {
        val request = Request.Builder().get().url(url).build()
        return OkHttpClient().newCall(request).execute()
    }
}
