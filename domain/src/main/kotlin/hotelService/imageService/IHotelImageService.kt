package hotelService.imageService

import hotelService.api.HotelResponse

interface IHotelImageService{
    fun getImage(hotel: HotelResponse) : String
}