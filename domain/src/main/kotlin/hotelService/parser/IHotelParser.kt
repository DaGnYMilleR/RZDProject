package hotelService.parser

import Hotel
import hotelService.responce.IHotelResponse

interface IHotelParser {
    fun parse(response: IHotelResponse): List<Hotel>
}