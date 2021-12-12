package main.controllers

import JourneysService
import Parameters
import main.models.JourneyParametersRequestQuery
import models.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class JourneysController @Autowired constructor(val journeysService: JourneysService) {

    @PostMapping("/journeys")
    @CrossOrigin(origins = ["*"])
    fun journeys(@RequestBody query: JourneyParametersRequestQuery) : List<Journey> {
        val tags = query.tags.map { Tag(it) }
        return journeysService.getJourneys(
            Parameters(
                City(query.cityName, tags, listOf()),
                query.budget,
                tags,
                DateSegment(query.dateFrom, query.dateTo)))
    }
}


