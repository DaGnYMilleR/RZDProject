package main

import HttpService
import hotelService.HotelService
import hotelService.IHotelService
import hotelService.api.HotelApi
import hotelService.api.IHotelApi
import hotelService.imageService.HotelImageService
import hotelService.imageService.IHotelImageService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class RZDApplication{
    @Bean
    fun httpService(): HttpService{
        return HttpService()
    }

    @Bean
    fun hotelAPi(): IHotelApi {
        return HotelApi(httpService())
    }

    @Bean
    fun hotelService(): IHotelService{
        return HotelService(hotelAPi(), hotelImageService())
    }

    @Bean
    fun hotelImageService(): IHotelImageService{
        return HotelImageService(httpService())
    }
}

fun main(args: Array<String>) {
    runApplication<RZDApplication>(*args)
}

