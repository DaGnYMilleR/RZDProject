package hotelService

import models.Hotel
import hotelService.parser.IHotelResponseParser
import hotelService.api.IHotelApi

class HotelService(private val hotelApi: IHotelApi, private val hotelResponseParser: IHotelResponseParser) : IHotelService {
    override fun getHotels(params: HotelServiceParams): List<Hotel> {
        val response = hotelApi.makeRequest(params.city, params.journeyDuration)
        return hotelResponseParser.parse(response)
    }
}