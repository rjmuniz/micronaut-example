package example.micronaut.business

import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Singleton
class EmailUseCase {
    fun send(user:String, message:String){
        LOG.info("Sending Email to {}: {} at {}", user, message, SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date()))
    }

    companion object{
        private val LOG= LoggerFactory.getLogger(EmailUseCase::class.java)
    }
}