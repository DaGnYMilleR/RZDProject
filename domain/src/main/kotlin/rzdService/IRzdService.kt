package rzdService

import models.Ticket

interface IRzdService {
    fun getTicket(rzdParams: RzdParams): List<Ticket>
}