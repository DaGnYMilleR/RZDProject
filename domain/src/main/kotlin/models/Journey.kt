package models

import models.hotel.Hotel

data class Journey(val city: City, val tickets: List<Ticket>, val hotels: List<Hotel>)