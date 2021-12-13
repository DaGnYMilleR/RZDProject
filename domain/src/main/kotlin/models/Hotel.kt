package models

import hotelService.api.GeoLocation

data class Hotel(
    val id: Int,
    val name: String,
    val address: GeoLocation,
    val price: Double,
    val rating: Int,
    val images: HotelImages?
)

data class HotelImages(val mainImage: String, val extraImages: List<String>)
