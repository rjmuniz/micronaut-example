package example.micronaut.services


import example.micronaut.services.Email
import example.micronaut.services.interfaces.MailService
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Requires
import javax.inject.Singleton

@Primary
@Requires(property = "spec.name", value = "mailcontroller")
@Singleton
class MockEmailService : MailService {
    val emails = mutableListOf<Email>()

    override fun send(email: Email) {
        emails.add(email)
    }
}