package main.controllers

import hotelService.api.HotelResponse
import hotelService.api.IHotelApi
import main.models.JourneyParametersRequestQuery
import models.City
import models.DateSegment
import models.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate


@RestController
@RequestMapping("/api")
class JourneysController @Autowired constructor(val hotelApi: IHotelApi) {

    @PostMapping("/journeys")
    fun journeys(@RequestBody query: JourneyParametersRequestQuery) : Array<HotelResponse> {

        return hotelApi.makeRequest(City("Moscow", listOf(Tag("test")), listOf(1, 2, 3)), DateSegment(LocalDate.now(), LocalDate.now().plusWeeks(1)))
        //return query
    }
}



