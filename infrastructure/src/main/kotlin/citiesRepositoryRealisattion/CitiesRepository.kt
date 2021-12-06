package citiesRepositoryRealisattion

import citiesRepository.ICitiesRepository
import models.City
import models.Tag

class CitiesRepository : ICitiesRepository {
    override fun getCitiesByTags(tags: List<Tag>): List<City> {
        TODO("Not yet implemented")
    }
}