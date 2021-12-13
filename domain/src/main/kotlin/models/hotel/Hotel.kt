package models.hotel

import hotelService.api.GeoLocation

data class Hotel(
    val id: Long,
    val name: String,
    val address: GeoLocation,
    val price: Double,
    val rating: Int,
    val images: HotelImages?
)

