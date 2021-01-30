package example.micronaut.services

interface Email {
    fun recipient(): String?
    fun cc(): List<String>?
    fun bcc(): List<String>?
    fun subject(): String?
    fun htmlBody(): String?
    fun textBody(): String?
    fun replyTo(): String?
}