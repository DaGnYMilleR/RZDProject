package hotelService

import hotelService.api.HotelResponse
import hotelService.api.IHotelApi
import hotelService.imageService.IHotelImageService
import models.hotel.Hotel

class HotelService(private val hotelApi: IHotelApi, private val imageService: IHotelImageService) : IHotelService {
    private val hotelsCount = 5
    private val maxHotelsFromApi = 500

    override fun getHotels(params: HotelServiceParams): List<Hotel> {
        val response = getHotelsFromApi(params)

        if(response.isEmpty())
            return emptyList()

        val images = imageService.getImages(response.map { it.hotelId })

        return response
            .map { Hotel(it.hotelId, it.hotelName, it.location.geo, it.priceAvg, it.stars,
                images[it.hotelId])
            }
    }

    private fun getHotelsFromApi(params: HotelServiceParams) : List<HotelResponse>
        = hotelApi.makeRequest(params.city, params.journeyDuration, maxHotelsFromApi)
            .filter { it.priceAvg <= params.budget }
            .sortedBy { it.priceAvg }
            .take(hotelsCount)
}