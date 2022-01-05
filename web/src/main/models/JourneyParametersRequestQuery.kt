package main.models

import java.time.LocalDate

data class JourneyParametersRequestQuery(
    val cityName: String,
    val trainsBudget: Double,
    val dateFrom: LocalDate,
    val dateTo: LocalDate,
    val tags: List<String>,
    val hotelsBudget: Double?,
)