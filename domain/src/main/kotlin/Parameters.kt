import models.DateSegment
import models.Tag
import rzdService.TrainCarType

data class Parameters(
    val cityName: String,
    val trainsBudget: Double,
    val tags: List<Tag>,
    val journeyDuration: DateSegment,
    val hotelsBudget: Double?,
    val typeOfTrainCar: TrainCarType,
)