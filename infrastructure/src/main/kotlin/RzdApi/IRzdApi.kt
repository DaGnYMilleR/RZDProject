package RzdApi

import City

interface IRzdApi {
    fun getTripCost(city: City): Double
}