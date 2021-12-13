package hotelService

import hotelService.api.IHotelApi
import hotelService.imageService.IHotelImageService
import models.Hotel

class HotelService(private val hotelApi: IHotelApi, private val imageService: IHotelImageService) : IHotelService {
    override fun getHotels(params: HotelServiceParams): List<Hotel> {
        val response = hotelApi.makeRequest(params.city, params.journeyDuration)
        return response
            .map { Hotel(it.hotelId, it.hotelName, it.location.geo, it.priceAvg, it.stars, imageService.getImages(it)) }
    }
}