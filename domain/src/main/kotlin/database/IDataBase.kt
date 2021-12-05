package database

import City
import Tag

interface IDataBase {
    fun getCitiesByTags(tags: List<Tag>): List<City>
}