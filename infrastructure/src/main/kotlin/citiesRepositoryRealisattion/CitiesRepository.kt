package citiesRepositoryRealisattion

import citiesRepository.ICitiesRepository
import citiesRepositoryRealisattion.Database.CityDao
import models.City
import models.Tag

class CitiesRepository(private val cityDao: CityDao) : ICitiesRepository {
    override fun getCitiesByTags(tags: List<Tag>): List<City> {
        return cityDao.getCitiesByTags(tags);
    }

    override fun getAllCities(): List<City> {
        return cityDao.getAllCities();
    }

    override fun getCityByName(name: String): City {
        return cityDao.getCityByName(name);
    }
}