package example.micronaut.controllers

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testHello(){
        val request : HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Hello World", body)
    }
}