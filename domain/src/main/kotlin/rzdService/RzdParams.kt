package rzdService

import models.City
import models.DateSegment

class RzdParams(val cityFrom: City,
                val cityTo: City,
                val journeyDuration: DateSegment,
                val cost: Double,
                val typeofTrainCar: TrainCarType)