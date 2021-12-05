package rzdService

import Ticket

interface IRZDService {
    fun getTrip(rzdParams: RzdParams): Ticket
}