package rzdService.api

import kotlinx.serialization.Serializable

@Serializable
data class Trip(val trainNumber: String, val categories: List<Category>, val numberForUrl: String)