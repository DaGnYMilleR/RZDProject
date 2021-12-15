package hotelService

import hotelService.api.HotelResponse
import hotelService.api.IHotelApi
import hotelService.imageService.IHotelImageService
import models.hotel.Hotel

class HotelService(private val hotelApi: IHotelApi, private val imageService: IHotelImageService) : IHotelService {
    private val hotelsCount = 5

    override fun getHotels(params: HotelServiceParams): List<Hotel> {
        val response = getHotels(hotelsCount, params)

        if(response.isEmpty())
            return emptyList()

        val images = imageService.getImages(response.map { it.hotelId })

        return response
            .map { Hotel(it.hotelId, it.hotelName, it.location.geo, it.priceAvg, it.stars,
                images[it.hotelId])
            }
    }

    private fun getHotels(count: Int, params: HotelServiceParams) : List<HotelResponse>{
        val step = 100
        var elementsCount = step
        val result = mutableListOf<HotelResponse>()

        for (i in 1..5){
            val responses = hotelApi.makeRequest(params.city, params.journeyDuration, elementsCount)

            for(response in responses.drop(elementsCount - step)){
                if(response.priceAvg <= params.budget){
                    result.add(response)
                }
                if(result.size == count)
                    return result
            }
            elementsCount += step
        }
        return result
    }
}