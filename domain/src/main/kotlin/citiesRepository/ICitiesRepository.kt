package citiesRepository

import models.City
import models.Tag

interface ICitiesRepository {
    fun getCitiesByTags(tags: List<Tag>): List<City>
}