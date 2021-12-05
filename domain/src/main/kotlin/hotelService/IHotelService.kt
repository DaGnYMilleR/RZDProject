package hotelService

import Hotel
import IParams

interface IHotelService {
    fun getHotels(params: IHotelServiceParams): List<Hotel>
}