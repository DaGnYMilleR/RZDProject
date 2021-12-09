import models.City
import models.DateSegment
import models.Tag

data class Parameters(
    override val city: City, override val money: Double,
    override val tags: List<Tag>, override val journeyDuration: DateSegment
) : IParameters