package main.controllers

import main.models.JourneyParametersRequestQuery
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class JourneysController {
    @PostMapping("/journeys")
    fun journeys(@RequestBody query: JourneyParametersRequestQuery) : JourneyParametersRequestQuery {
        return query
    }
}