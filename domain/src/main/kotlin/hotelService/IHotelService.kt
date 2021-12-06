package hotelService

import models.Hotel

interface IHotelService {
    fun getHotels(params: IHotelServiceParams): List<Hotel>
}