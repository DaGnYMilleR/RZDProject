package hotelService.api

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val country: String,
    val geo: GeoLocation,
    val state: String?,
    val name: String
)