package models

import hotelService.api.GeoLocation

data class Hotel(
    val name: String,
    val address: GeoLocation,
    val price: Double,
    val rating: Int)
