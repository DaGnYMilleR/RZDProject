package citiesRepositoryRealisation

import citiesRepository.ICitiesRepository
import citiesRepositoryRealisation.database.CityDao
import models.City
import models.Tag

class CitiesRepository(private val cityDao: CityDao) : ICitiesRepository {
    override fun getCitiesByTags(tags: List<Tag>, count: Int): List<City> {
        return cityDao.getCitiesByTags(tags, count)
    }

    override fun getCitiesByTags(tags: List<Tag>): List<City> {
        return cityDao.getCitiesByTags(tags)
    }

    override fun getAllCities(): List<City> {
        return cityDao.getAllCities()
    }

    override fun getCityByName(name: String): City {
        return cityDao.getCityByName(name)
    }
}