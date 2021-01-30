package example.micronaut.jobs

import example.micronaut.business.RegisterUseCase
import example.micronaut.models.Product
import example.micronaut.services.ProductService
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import org.slf4j.LoggerFactory
import java.lang.Exception
import javax.inject.Singleton
import kotlin.concurrent.thread

@Singleton
class BootStrap(val registerUseCase: RegisterUseCase, val productService: ProductService) :
    ApplicationEventListener<ServerStartupEvent> {

    override fun onApplicationEvent(event: ServerStartupEvent?) {

        try {
            registerUseCase.register("joaozinho1@test.com")
            Thread.sleep(10000)
            registerUseCase.register("joaozinho2@test.com")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        try {
            LOG.info("add product 1")
            productService.insert(Product(1, "item 1"))
        } catch (e: Exception) {
            LOG.error(e.message)
            e.printStackTrace()
        }
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(HelloWorldJob::class.java)
    }
}