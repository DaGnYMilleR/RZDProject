package main.controllers

import hotelService.HotelServiceParams
import hotelService.IHotelService
import main.models.JourneyParametersRequestQuery
import models.City
import models.DateSegment
import models.Hotel
import models.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@RestController
@RequestMapping("/api")
class JourneysController @Autowired constructor(val hotelService: IHotelService) {

    @PostMapping("/journeys")
    @CrossOrigin(origins = ["*"])
    fun journeys(@RequestBody query: JourneyParametersRequestQuery) : List<Hotel> {
        return hotelService.getHotels(HotelServiceParams(
            City("Moscow", listOf(Tag("test")), listOf(1, 2, 3)),
            DateSegment(LocalDate.now(), LocalDate.now().plusWeeks(1))))
    }
}



