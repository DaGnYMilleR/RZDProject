package hotelService.api

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import models.City
import models.DateSegment
import okhttp3.*
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class HotelApi : IHotelApi {
    private val client = OkHttpClient()

    override fun makeRequest(destinationCity: City, journeyDuration: DateSegment): HotelResponse2 {
        val url = "http://engine.hotellook.com/api/v2/cache.json?location=${destinationCity.name}" +
                "&currency=rub&checkIn=${journeyDuration.start}&checkOut=${journeyDuration.end}&limit=20"
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())
            //println("test")
            //println(Json.decodeFromString<HotelResponse2>(response.body!!.string()).toString())
            //println(Json.decodeFromString(response.body!!.string()).)
            //println(Json.decodeFromString(response.body!!.string()))
            return Json.decodeFromString(response.body!!.string())
        }
    }
}
