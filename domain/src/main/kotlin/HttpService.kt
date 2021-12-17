import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class HttpService {
    val json = Json { ignoreUnknownKeys = true }
    private val okHttpClient: OkHttpClient = OkHttpClient()

    inline fun <reified T> getResponse(url: String): T? {
        val response = call(url)
        if (response.body == null ||  response.body!!.string() == "[]")
            return null
        return json.decodeFromString(response.body!!.string())
    }

    fun call(url: String): Response {
        val request = Request
            .Builder()
            .get()
            .url(url)
            .build()
        return okHttpClient.newCall(request).execute()
    }
}