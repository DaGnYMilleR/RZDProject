import models.City
import models.DateSegment
import models.Tag

interface IParameters {
    val city: City
    val journeyDuration: DateSegment
    val money: Double
    val tags: List<Tag>
}

