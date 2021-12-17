package rzdService.api

import kotlinx.serialization.Serializable

@Serializable
data class Category(val type: String, val price: Double)