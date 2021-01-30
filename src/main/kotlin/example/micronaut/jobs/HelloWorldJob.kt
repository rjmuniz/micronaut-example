package example.micronaut.jobs

import io.micronaut.scheduling.annotation.Scheduled
import javax.inject.Singleton
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat
import java.util.*

@Singleton
class HelloWorldJob {

    @Scheduled(fixedDelay = "40s")
    fun executeEveryTen() {
        LOG.info("Simple Job every 10s {}", SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Date()))
    }

    @Scheduled(fixedDelay = "75s", initialDelay = "5s")
    fun executeEveryFortyFive() {
        LOG.info("Simple Job every 45s {}", SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Date()))
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(HelloWorldJob::class.java)
    }
}