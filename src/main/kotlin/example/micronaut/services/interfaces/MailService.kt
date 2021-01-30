package example.micronaut.services.interfaces

import example.micronaut.services.Email

interface MailService {
    fun send(email: Email)
}