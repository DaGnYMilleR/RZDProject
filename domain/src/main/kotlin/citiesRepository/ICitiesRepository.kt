package citiesRepository

import models.City
import models.Tag

interface ICitiesRepository {
    fun getCitiesByTags(tags: List<Tag>, count: Int): List<City>
    fun getCitiesByTags(tags: List<Tag>): List<City>
    fun getAllCities(): List<City>
    fun getCityByName(name: String): City
}