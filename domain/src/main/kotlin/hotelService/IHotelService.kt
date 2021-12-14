package hotelService

import models.hotel.Hotel

interface IHotelService {
    fun getHotels(params: HotelServiceParams): List<Hotel>
}