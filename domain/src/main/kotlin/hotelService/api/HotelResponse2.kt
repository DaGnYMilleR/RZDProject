package hotelService.api

import kotlinx.serialization.Serializable

@Serializable
data class HotelResponse2(
    val location: Location,
    val priceAvg: Double,
    val pricePercentile: HashMap<String, Double>,
    val hotelName: String,
    val stars: Int,
    val locationId: Int,
    val hotelId: Int,
    val priceFrom: Double)

@Serializable
data class Location(
    val country: String,
    val geo: GeoLocation,
    val state: String?,
    val name: String)

@Serializable
data class GeoLocation(
    val lon: Float,
    val lat: Float)
