package example.micronaut

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class ProductServiceControllerTest(private val embeddedServer: EmbeddedServer) {

    @Test
    fun testServerIsRunning() {
        assert(embeddedServer.isRunning())
    }

    @Test
    fun testIndex() {
        val client: RxHttpClient = embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/productController", String::class.java).status())
        client.close()
    }
}
