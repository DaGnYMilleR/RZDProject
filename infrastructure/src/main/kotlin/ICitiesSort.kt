import MetricProvider.IMetricsProvider

interface ICitiesSort{
    fun getSortedCities(cities: List<City>, metric: IMetricsProvider): List<City>
}