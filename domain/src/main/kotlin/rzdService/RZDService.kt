package rzdService

import rzdService.parser.IRzdParser
import rzdService.request.IRzdRequest
import Ticket

class RZDService(private val rzdRequest: IRzdRequest, private val rzdParser: IRzdParser) : IRZDService {
    override fun getTrip(rzdParams: RzdParams): Ticket {
        val response = rzdRequest.request(rzdParams.cityFrom, rzdParams.cityTo, rzdParams.tripDuration)
        return rzdParser.parse(response)
    }
}