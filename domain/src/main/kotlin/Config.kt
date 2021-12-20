import io.github.cdimascio.dotenv.dotenv

class Config {
    private val dotenv = dotenv();

    fun getPathToDB(key: String): String = dotenv[key]
}