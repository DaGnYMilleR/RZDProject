package rzdService.parser

import models.Ticket
import rzdService.response.IRzdResponse

interface IRzdResponseParser {
    fun parse(response: IRzdResponse): Ticket
}