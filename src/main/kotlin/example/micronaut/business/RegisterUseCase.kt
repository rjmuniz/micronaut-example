package example.micronaut.business


import example.micronaut.jobs.HelloWorldJob
import example.micronaut.tasks.EmailTask
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.TaskScheduler
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class RegisterUseCase(private val emailUseCase: EmailUseCase,
@param:Named(TaskExecutors.SCHEDULED) private val taskScheduler: TaskScheduler) {

    fun register(email: String) {
        LOG.info("saving {} at {}", email, SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Date()))
        scheduledFollowupEmail(email, "Welcome to Micronaut")
    }

    fun scheduledFollowupEmail(email: String, message:String){
        val task = EmailTask(emailUseCase, email, message)
        taskScheduler.schedule(Duration.ofMinutes(1), task)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(HelloWorldJob::class.java)
    }
}