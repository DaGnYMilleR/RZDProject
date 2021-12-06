import models.City
import models.DateSegment
import models.Tag

interface IParams {
    val city: City
    val journeyDuration: DateSegment
    val money: Double
    val tags: List<Tag>
}

