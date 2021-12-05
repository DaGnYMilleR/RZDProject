package rzdService.parser

import rzdService.response.IRzdResponse
import Ticket

interface IRzdParser {
    fun parse(response: IRzdResponse): Ticket
}