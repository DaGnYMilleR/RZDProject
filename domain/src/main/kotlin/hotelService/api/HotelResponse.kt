package hotelService.api

import kotlinx.serialization.Serializable

@Serializable
data class HotelResponse(
    val location: Location,
    val priceAvg: Double,
    val pricePercentile: HashMap<String, Double>,
    val hotelName: String,
    val stars: Int,
    val locationId: Int,
    val hotelId: Long,
    val priceFrom: Double
)

