package hotelService.api

import kotlinx.serialization.Serializable

@Serializable
data class GeoLocation(
    val lon: Float,
    val lat: Float)