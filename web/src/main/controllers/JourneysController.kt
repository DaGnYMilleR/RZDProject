package main.controllers

import JourneysService
import Parameters
import main.models.JourneyParametersRequestQuery
import models.DateSegment
import models.Journey
import models.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class JourneysController @Autowired constructor(val journeysService: JourneysService) {

    @PostMapping("/journeys")
    @CrossOrigin(origins = ["*"])
    fun journeys(@RequestBody query: JourneyParametersRequestQuery): List<Journey> {
        val tags = query.tags.map { Tag(it) }
        val journeyDuration = DateSegment(query.dateFrom, query.dateTo)
        val parameters = Parameters(query.cityName, query.budget, tags, journeyDuration)
        return journeysService.getJourneys(parameters)
    }
}


