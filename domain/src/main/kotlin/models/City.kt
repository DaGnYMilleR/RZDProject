package models

data class City(val name: String, val tags: List<Tag>, val stationsId: List<Int>, val photoUrl: String)
