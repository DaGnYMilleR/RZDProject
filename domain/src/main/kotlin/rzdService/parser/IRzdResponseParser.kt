package rzdService.parser

import rzdService.response.IRzdResponse
import models.Ticket

interface IRzdResponseParser {
    fun parse(response: IRzdResponse): Ticket
}