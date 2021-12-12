package hotelService

import models.Hotel

interface IHotelService {
    fun getHotels(params: HotelServiceParams): List<Hotel>
}