package citiesRepositoryRealisation.database

import Config
import kotlinx.serialization.json.*
import models.City
import models.Tag
import java.io.File
import java.io.InputStream
import java.security.SecureRandom
import java.util.ArrayList




class CityDao {
    private val jsonObj: JsonObject
    private val pathToJson : String = Config().getPathToDB("pathToDB")

    init {
        val inputStream: InputStream = File(pathToJson).inputStream()
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        jsonObj = Json.parseToJsonElement(jsonString).jsonObject
    }

    fun getCitiesByTags(tags: List<Tag>, count: Int): List<City> {
        if (tags.isEmpty())
            return showUniqueRandomElements(getAllCities(), count)
        return getCitiesByTags(tags)
            .take(count)
    }

    fun getCitiesByTags(tags: List<Tag>): List<City> {
        val tagsSet = tags.toSet()
        return getAllCities()
            .sortedBy { city -> city.tags.toSet().intersect(tagsSet).count() }
            .reversed()
            .filter { city -> city.tags.any{ it in tagsSet } }
    }

    fun getAllCities(): List<City> {
        return jsonObj.keys.map { city -> getCityByName(city) }.toList()
    }


    fun getCityByName(cityName: String): City {
        val cityInfo = jsonObj[cityName] ?: throw IllegalArgumentException("City not found")
        val tags = cityInfo.jsonObject["Tags"]
        val terminals = cityInfo.jsonObject["Terminal"]
        val photoUrl = cityInfo.jsonObject.getValue("url").jsonPrimitive.content
        val stationsId =
            terminals?.jsonObject?.values?.map { x -> "$x".substring(1, "$x".length - 1).toInt() }?.toList()
        return City(cityName, fromJsonObjectToTagList(tags?.jsonArray!!), stationsId!!, photoUrl)
    }

    private fun showUniqueRandomElements(source: List<City>, elementCount: Int): List<City> {
        val random = SecureRandom()
        val list = ArrayList(source)
        val result = arrayListOf<City>();
        for (i in 0 until elementCount) {
            val randomIndex: Int = random.nextInt(list.size)
            val randomElement = list[randomIndex]
            result.add(randomElement)
            list.removeAt(randomIndex)
        }
        return result
    }

    private fun fromJsonObjectToTagList(jsonArray: JsonArray): List<Tag> {
        val tags = arrayListOf<Tag>()
        (0 until jsonArray.size).forEach { i ->
            tags.add(Tag(jsonArray[i].toString().replace("\"", "")))
        }
        return tags
    }
}