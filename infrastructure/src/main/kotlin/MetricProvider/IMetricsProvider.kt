package MetricProvider

import City

interface IMetricsProvider {
    fun getMetrics(city: City, otherCity: City): Int
}