package example.micronaut.services.condictions

import example.micronaut.services.AwsSesMailService
import io.micronaut.context.ApplicationContext
import io.micronaut.context.exceptions.NoSuchBeanException
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertFailsWith

class AwsSesMailServiceSpek:Spek ({
    describe("AwsSesMailService load") {
        val applicationContext = ApplicationContext.run("test")
        it("AwsSesMailService is not loaded if system property is not present") {
            assertFailsWith<NoSuchBeanException> {
                applicationContext.getBean(AwsSesMailService::class.java)
            }
        }
        afterGroup {
            applicationContext.close()
        }
    }
})