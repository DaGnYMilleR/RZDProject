package main.controllers

import hotelService.api.HotelApi
import main.models.JourneyParametersRequestQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class JourneysController @Autowired constructor(val hotelApi: HotelApi) {

    @PostMapping("/journeys")
    fun journeys(@RequestBody query: JourneyParametersRequestQuery) : JourneyParametersRequestQuery {
        return query
    }
}