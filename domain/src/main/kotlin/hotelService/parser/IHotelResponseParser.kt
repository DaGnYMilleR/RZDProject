package hotelService.parser

import models.Hotel
import hotelService.responce.IHotelResponse

interface IHotelResponseParser {
    fun parse(response: IHotelResponse): List<Hotel>
}