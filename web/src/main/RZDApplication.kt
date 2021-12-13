package main

import HttpService
import JourneysService
import citiesRepository.ICitiesRepository
import citiesRepositoryRealisation.CitiesRepository
import citiesRepositoryRealisation.database.CityDao
import filters.*
import hotelService.HotelService
import hotelService.IHotelService
import hotelService.api.HotelApi
import hotelService.api.IHotelApi
import hotelService.imageService.HotelImageMock
import hotelService.imageService.IHotelImageService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import rzdService.IRzdService
import rzdService.RzdService
import rzdService.api.IRzdApi
import rzdService.api.MockedRzdApi
import rzdService.parser.IRzdResponseParser
import rzdService.parser.RzdResponseParser

fun main(args: Array<String>) {
    runApplication<RZDApplication>(*args)
}

@SpringBootApplication
class RZDApplication{
    @Bean
    fun httpService(): HttpService = HttpService()

    @Bean
    fun hotelApi(): IHotelApi = HotelApi(httpService())

    @Bean
    fun hotelService(): IHotelService = HotelService(hotelApi(), hotelImageService())

    @Bean
    fun hotelImageService(): IHotelImageService = HotelImageMock(httpService())

    @Bean
    fun cities() : ICitiesRepository = CitiesRepository(CityDao())

    @Bean
    fun rzdApi() : IRzdApi = MockedRzdApi()

    @Bean
    fun rzdResponseParser() : IRzdResponseParser = RzdResponseParser()

    @Bean
    fun rzd() : IRzdService = RzdService(rzdApi(), rzdResponseParser())

    @Bean
    fun filter() : List<IFilter> = listOf(MoneyFilter(), PlaceFilter())

    @Bean
    fun compositeFilter() : ICompositeFilter = CompositeFilter(filter())

    @Bean
    fun journeyService(): JourneysService = JourneysService(cities(), rzd(), hotelService(), compositeFilter())
}