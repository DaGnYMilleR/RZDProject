package hotelService.imageService

import HttpService
import hotelService.api.HotelResponse
import models.HotelImages

class HotelImageService(private val httpService: HttpService) : IHotelImageService {
    override fun getImages(hotel: HotelResponse): HotelImages? {
        val url = "https://yasen.hotellook.com/photos/hotel_photos?id=${hotel.hotelId}"
        val response = httpService.getResponse<HashMap<String, List<Long>>>(url)

        val imageIds = response[hotel.hotelId.toString()] ?: return null

        if(imageIds.count() == 1)
            return HotelImages(imageIds.first().toString(), listOf())

        return HotelImages(imageIds.first().toString(), imageIds.drop(1).map { it.toString() })
    }
}

class HotelImageMock(private val httpService: HttpService) : IHotelImageService {
    override fun getImages(hotel: HotelResponse): HotelImages? = null
}