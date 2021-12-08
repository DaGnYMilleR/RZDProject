package hotelService.api

import kotlinx.serialization.Serializable
import org.springframework.stereotype.Component

@Serializable
@Component
data class HotelResponse2(val priceAvg: Double, val hotelName: String, val stars: Int)