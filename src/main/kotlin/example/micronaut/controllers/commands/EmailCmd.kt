package example.micronaut.controllers.commands

import example.micronaut.services.Email
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
@EmailConstraints
class EmailCmd:Email {
    @NotBlank
    @NotNull
    var recipient:String? = null

    @NotBlank
    @NotNull
    var subject: String? = null

    var cc: List<String>? = null
    var bcc: List<String>? = null
    var htmlBody: String? = null
    var textBody: String? = null
    var replyTo:String? = null
    override fun recipient(): String? {
       return recipient
    }

    override fun cc(): List<String>? {
        return cc
    }

    override fun bcc(): List<String>? {
        return bcc
    }

    override fun subject(): String? {
        return subject
    }

    override fun htmlBody(): String? {
        return htmlBody
    }

    override fun textBody(): String? {
        return textBody
    }

    override fun replyTo(): String? {
        return replyTo
    }

}