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
    private val apiUrl = "http://engine.hotellook.com/api/v2/cache.json?location=%s" +
                    "&currency=rub&checkIn=%s&checkOut=%s&limit=20"

    override fun makeRequest(destinationCity: City, journeyDuration: DateSegment): Array<HotelResponse> {
        val url = java.lang.String.format(apiUrl, destinationCity.name, journeyDuration.start, journeyDuration.end)

        return Json.decodeFromString(call(url).body!!.string())
    }

    fun call(url: String): Response {
        val request = Request.Builder().get().url(url).build()
        return OkHttpClient().newCall(request).execute()
    }
}
