package rzdService.api

import models.City
import models.DateSegment
import models.Ticket
import rzdService.TrainCarType


interface IRzdApi {
    fun makeRequest(cityFrom: City, cityTo: City,
                    journeyDuration: DateSegment, cost: Double, typeofTrainCar: TrainCarType): List<Ticket>
}
