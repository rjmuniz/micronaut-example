package example.micronaut.info

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject
import org.junit.jupiter.api.Assertions.*

@MicronautTest
class InfoTest {
    @Inject
    @field:Client("/")
    lateinit var client: RxHttpClient

    @Test
    fun testGitCommitInfoAppersInJson(){
        val request :HttpRequest<*> = HttpRequest.GET<Any>("/info")
        val rsp = client.toBlocking().exchange(request, Info::class.java)
        assertEquals(200, rsp.status().code)
        val info = rsp.body()
        assertNotNull(info)
        assertNotNull(info!!.git)
        assertNotNull(info.git!!.commit)
        assertNotNull(info.git!!.commit!!.id)
    }

}