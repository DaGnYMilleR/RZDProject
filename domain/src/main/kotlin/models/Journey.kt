package models

import models.hotel.Hotel

data class Journey(val city: City, val ticket: Ticket, val hotels: List<Hotel>)