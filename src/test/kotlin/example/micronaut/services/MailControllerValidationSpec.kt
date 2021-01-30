package example.micronaut.services


import example.micronaut.controllers.commands.EmailCmd
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertFailsWith

class MailControllerValidationSpec : Spek({

    describe("MailController Validation") {
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java, mapOf("spec.name" to "mailcontroller"),
            "test")
        var client: RxHttpClient = RxHttpClient.create(embeddedServer.url)

        it("/mail/send cannot be invoked without subject") {
            val cmd = EmailCmd()
            cmd.recipient = "delamos@micronaut.example"
            cmd.textBody = "Hola hola"

            val request = HttpRequest.POST("/mail/send", cmd)

            assertFailsWith<HttpClientResponseException> {
                client.toBlocking().exchange(request, HttpResponse::class.java)
            }
        }

        it("/mail/send cannot be invoked without recipient") {
            val cmd = EmailCmd()
            cmd.subject = "Hola"
            cmd.textBody = "Hola hola"
            val request = HttpRequest.POST("/mail/send", cmd)

            assertFailsWith<HttpClientResponseException> {
                client.toBlocking().exchange(request, HttpResponse::class.java)
            }
        }

        it("/mail/send cannot be invoked without either textBody or htmlBody") {
            val cmd = EmailCmd()
            cmd.subject = "Hola"
            cmd.recipient = "delamos@micronaut.example"
            val request = HttpRequest.POST("/mail/send", cmd)

            assertFailsWith<HttpClientResponseException> {
                client.toBlocking().exchange(request, HttpResponse::class.java)
            }
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})