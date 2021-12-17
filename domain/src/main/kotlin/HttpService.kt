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
        val tex = response.body!!.string()
        if (tex == "[]")
            return null
        return json.decodeFromString(tex)
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