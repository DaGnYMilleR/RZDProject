import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class HttpService{

    inline fun<reified T> getResponse(url: String) : T {
        val response = call(url)

        return Json.decodeFromString(response.body!!.string())
    }

    fun call(url: String) : Response {
        val request = Request
                .Builder()
                .get()
                .url(url)
                .build()
        return OkHttpClient().newCall(request).execute()
    }
}