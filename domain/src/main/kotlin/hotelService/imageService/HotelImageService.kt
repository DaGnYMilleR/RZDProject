package hotelService.imageService

import HttpService
import hotelService.api.HotelResponse

class HotelImageService(private val httpService: HttpService) : IHotelImageService {
    override fun getImage(hotel: HotelResponse): String {
        val url = "https://yasen.hotellook.com/photos/hotel_photos?id=${hotel.hotelId}"
        val response = httpService.getResponse<HashMap<String, List<Long>>>(url)

        val imageIds = response[hotel.hotelId.toString()]

        return "https://photo.hotellook.com/image_v2/limit/${imageIds?.first()}/800/520.auto"
    }
}