package rzdService.api

import kotlinx.serialization.Serializable

@Serializable
data class RzdResponse(val trips: List<Trip>)