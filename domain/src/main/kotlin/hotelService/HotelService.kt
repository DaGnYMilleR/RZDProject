package hotelService

import models.Hotel
import hotelService.parser.IHotelResponseParser
import hotelService.api.IHotelApi
import hotelService.responce.HotelResponse

class HotelService(private val hotelApi: IHotelApi, private val hotelResponseParser: IHotelResponseParser) : IHotelService {
    override fun getHotels(params: IHotelServiceParams): List<Hotel> {
        val response = hotelApi.makeRequest(params.city, params.journeyDuration)
        return hotelResponseParser.parse(HotelResponse())
    }
}