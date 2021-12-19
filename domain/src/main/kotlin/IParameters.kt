import models.DateSegment
import models.Tag

interface IParameters {
    val cityName: String
    val journeyDuration: DateSegment
    val money: Double
    val tags: List<Tag>
}

