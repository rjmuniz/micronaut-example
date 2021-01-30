package example.micronaut.jobs

import example.micronaut.business.EmailUseCase
import io.micronaut.scheduling.annotation.Scheduled
import javax.inject.Singleton

@Singleton
class DailyEmailJob(protected val emailUseCase: EmailUseCase) {
    private var counter = 1
    //@Scheduled(cron = "0 30 4 1/1 * ?")
    @Scheduled(fixedDelay = "30s")
    fun execute(){
        emailUseCase.send("test@test.com", "message "+ (counter++).toString())
    }
}