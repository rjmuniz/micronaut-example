package example.micronaut.controllers

import example.micronaut.controllers.commands.EmailCmd
import example.micronaut.services.interfaces.MailService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/mail")
open class MailController(private val mailService: MailService) {

    @Post(uri="/send")
    open fun send(@Body @Valid cmd: EmailCmd): HttpResponse<*> {
        mailService.send(cmd)
        return HttpResponse.ok<Any>()
    }
}