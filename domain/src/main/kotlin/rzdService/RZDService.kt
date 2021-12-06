package rzdService

import rzdService.parser.IRzdResponseParser
import rzdService.api.IRzdApi
import models.Ticket

class RZDService(private val rzdRequest: IRzdApi, private val rzdResponseParser: IRzdResponseParser) : IRZDService {
    override fun getTicket(rzdParams: RzdParams): Ticket {
        val response = rzdRequest.request(rzdParams.cityFrom, rzdParams.cityTo, rzdParams.journeyDuration)
        return rzdResponseParser.parse(response)
    }
}