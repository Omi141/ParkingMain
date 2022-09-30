import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.util.concurrent.TimeUnit

object RestApiCalls {
    private val client = HttpClient(OkHttp) {
        engine {
            config {
                retryOnConnectionFailure(true)
                connectTimeout(5, TimeUnit.SECONDS)
            }
        }
    }

    suspend fun getHtml(): String {
        val response: HttpResponse = client.get("https://fakestoreapi.com/products")
        return response.bodyAsText()
    }
}