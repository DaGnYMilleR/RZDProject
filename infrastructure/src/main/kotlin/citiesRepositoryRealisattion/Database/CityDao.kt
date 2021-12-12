package citiesRepositoryRealisattion.Database

import kotlinx.serialization.json.*
import models.City
import models.Tag
import org.springframework.web.client.HttpClientErrorException
import java.io.File
import java.io.InputStream

class CityDao() {
    private val jsonObj: JsonObject;
    private val pathToJson = "./assets/cities.json";
    init {
        val inputStream: InputStream = File(pathToJson).inputStream()
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        jsonObj = Json.parseToJsonElement(jsonString).jsonObject
    }
    fun getCitiesByTags(tags: List<Tag>): List<City>{
        return getAllCities()
                .sortedBy { city -> city.tags.toSet().intersect(tags.toSet()).count()}
                .reversed()
    }

    fun getAllCities(): List<City>{
        return jsonObj.keys.map { city -> getCityByName(city) }.toList()
    }

    fun getCityByName(cityName: String): City{
        val cityInfo = jsonObj[cityName] ?: throw IllegalArgumentException("City not found");
        val tags = cityInfo.jsonObject["Tags"]
        val terminals = cityInfo.jsonObject["Terminal"]
        val stationsId = terminals?.jsonObject?.values?.map {  x -> "$x".substring(1, "$x".length - 1).toInt() }?.toList()
        return City(cityName, fromJsonObjectToTagList(tags?.jsonArray!!), stationsId!!);
    }

    private fun fromJsonObjectToTagList(jsonArray: JsonArray): List<Tag>{
        val tags = arrayListOf<Tag>()
        (0 until jsonArray.size).forEach { i ->
            tags.add(Tag(jsonArray[i].toString()))
        }
        return tags;
    }
}