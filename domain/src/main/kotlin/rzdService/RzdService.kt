package rzdService

import models.Ticket
import rzdService.api.IRzdApi
import rzdService.parser.IRzdResponseParser

class RzdService(private val rzdRequest: IRzdApi, private val rzdResponseParser: IRzdResponseParser) : IRzdService {
    override fun getTicket(rzdParams: RzdParams): List<Ticket> {
        return rzdRequest.request(rzdParams.cityFrom, rzdParams.cityTo, rzdParams.journeyDuration, rzdParams.cost)
       // return rzdResponseParser.parse(response)
    }
}