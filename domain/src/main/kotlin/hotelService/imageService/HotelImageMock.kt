package hotelService.imageService

import HttpService
import models.hotel.HotelImages

class HotelImageMock(private val httpService: HttpService) : IHotelImageService {
    override fun getImages(hotelId: Long): HotelImages? = null
    override fun getImages(hotelIds: List<Long>): Map<Long, HotelImages> {
        TODO("Not yet implemented")
    }
}