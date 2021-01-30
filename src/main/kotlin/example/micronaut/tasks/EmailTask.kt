package example.micronaut.tasks

import example.micronaut.business.EmailUseCase

class EmailTask(private val emailUseCase: EmailUseCase,
                private val email: String,
                private val message: String):Runnable {

    override fun run() {
        emailUseCase.send(email, message)
    }
}