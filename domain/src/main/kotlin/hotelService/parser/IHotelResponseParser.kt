package hotelService.parser

import hotelService.api.HotelResponse2
import models.Hotel
import hotelService.responce.IHotelResponse

interface IHotelResponseParser {
    fun parse(response: Array<HotelResponse2>): List<Hotel>
}

class HotelResponseParser : IHotelResponseParser{
    override fun parse(response: Array<HotelResponse2>): List<Hotel> {
        return response.map { Hotel(it.hotelName, it.location.geo, it.priceAvg, it.stars) }
    }
}