package hotelService.imageService

import models.hotel.HotelImages

class MockedHotelImageService : IHotelImageService {
    override fun getImages(hotelIds: List<Long>): Map<Long, HotelImages> {
        return hotelIds.associateBy({it}, {HotelImages(0, emptyList())})
    }
}