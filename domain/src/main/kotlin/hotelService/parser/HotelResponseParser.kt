package hotelService.parser

import hotelService.api.HotelResponse
import models.Hotel

class HotelResponseParser : IHotelResponseParser {
    override fun parse(response: Array<HotelResponse>): List<Hotel> {
        return response.map { Hotel(it.hotelId, it.hotelName, it.location.geo, it.priceAvg, it.stars) }
    }
}