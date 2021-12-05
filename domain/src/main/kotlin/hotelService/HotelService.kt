package hotelService

import Hotel
import hotelService.parser.IHotelParser
import hotelService.request.IHotelRequest
import IParams

class HotelService(private val hotelRequest: IHotelRequest, private val hotelParser: IHotelParser) : IHotelService {
    override fun getHotels(params: IHotelServiceParams): List<Hotel> {
        val response = hotelRequest.request(params.city, params.tripDuration)
        return hotelParser.parse(response)
    }
}