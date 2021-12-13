package hotelService.imageService

import hotelService.api.HotelResponse
import models.HotelImages

interface IHotelImageService {
    fun getImages(hotel: HotelResponse): HotelImages?
}