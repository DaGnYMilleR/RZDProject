package rzdService

import models.Ticket
import rzdService.api.IRzdApi
import rzdService.parser.IRzdResponseParser

class RzdService(private val rzdRequest: IRzdApi, private val rzdResponseParser: IRzdResponseParser) : IRzdService {
    override fun getTicket(rzdParams: RzdParams): Ticket {
        val response = rzdRequest.request(rzdParams.cityFrom, rzdParams.cityTo, rzdParams.journeyDuration)
        return rzdResponseParser.parse(response)
    }
}