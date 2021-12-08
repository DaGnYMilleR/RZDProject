package main

import hotelService.api.HotelApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class RZDApplication{
    @Bean
    fun hotelService(): HotelApi {
        return HotelApi()
    }
}

fun main(args: Array<String>) {
    runApplication<RZDApplication>(*args)
}

