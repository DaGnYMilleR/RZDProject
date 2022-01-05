import models.DateSegment
import models.Tag

data class Parameters(
    val cityName: String,
    val trainsBudget: Double,
    val tags: List<Tag>,
    val journeyDuration: DateSegment,
    val hotelsBudget: Double?
)