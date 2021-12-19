package hotelService.imageService

import HttpService
import models.hotel.HotelImages

class HotelImageService(private val httpService: HttpService) : IHotelImageService {
    override fun getImages(hotelId: Long): HotelImages? {
        val url = "https://yasen.hotellook.com/photos/hotel_photos?id=${hotelId}"
        val response = httpService.getResponse<HashMap<Long, List<Long>>>(url)!!
        val imageIds = response[hotelId] ?: return null

        return createHotelImages(imageIds)
    }

    override fun getImages(hotelIds: List<Long>): Map<Long, HotelImages> {
        val baseUrl = "https://yasen.hotellook.com/photos/hotel_photos?id=${hotelIds.joinToString { it.toString() }}"
        val response = httpService.getResponse<HashMap<Long, List<Long>>>(baseUrl) ?: return emptyMap()
        return response.mapValues { createHotelImages(it.value) }
    }

    private fun createHotelImages(ids: List<Long>) : HotelImages {
        if(ids.count() == 1)
            return HotelImages(ids.first(), listOf())
        return HotelImages(ids.first(), ids.drop(1))
    }
}

