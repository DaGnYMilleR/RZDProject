package main

import hotelService.api.HotelApi
import hotelService.api.IHotelApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class RZDApplication{
    @Bean
    fun hotelService(): IHotelApi {
        return HotelApi()
    }
}

fun main(args: Array<String>) {
    runApplication<RZDApplication>(*args)
}

