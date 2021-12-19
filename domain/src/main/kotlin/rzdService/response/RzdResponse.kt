package rzdService.response

import hotelService.api.Location
import kotlinx.serialization.Serializer



data class RzdResponse(
    val l: Location.Companion

) : IRzdResponse{

}