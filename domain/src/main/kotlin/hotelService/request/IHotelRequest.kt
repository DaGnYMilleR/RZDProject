package hotelService.request

import City
import DateSegment
import hotelService.responce.IHotelResponse

interface IHotelRequest {
    fun request(city: City, tripDuration: DateSegment): IHotelResponse
}