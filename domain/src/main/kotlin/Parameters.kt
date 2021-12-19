import models.DateSegment
import models.Tag

data class Parameters(
    override val cityName: String,
    override val money: Double,
    override val tags: List<Tag>,
    override val journeyDuration: DateSegment
) : IParameters