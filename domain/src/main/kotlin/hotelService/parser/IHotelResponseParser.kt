package hotelService.parser

import hotelService.api.HotelResponse
import models.Hotel

interface IHotelResponseParser {
    fun parse(response: Array<HotelResponse>): List<Hotel>
}

