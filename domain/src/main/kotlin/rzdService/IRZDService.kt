package rzdService

import models.Ticket

interface IRZDService {
    fun getTicket(rzdParams: RzdParams): Ticket
}