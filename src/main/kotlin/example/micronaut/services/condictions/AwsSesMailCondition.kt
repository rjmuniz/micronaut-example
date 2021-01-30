package example.micronaut.services.condictions

import io.micronaut.context.condition.Condition
import io.micronaut.context.condition.ConditionContext
import io.micronaut.core.util.StringUtils

class AwsSesMailCondition:Condition {
    override fun matches(context: ConditionContext<*>): Boolean {
        return envOrSysPropNotBlankAndNotNull("AWS_SOURCE_EMAIL", "aws.sourceemail")
                && envOrSysPropNotBlankAndNotNull("AWS_REGION", "aws.region")
    }

    private fun envOrSysPropNotBlankAndNotNull(env: String?, prop: String?): Boolean {
        return StringUtils.isNotEmpty(System.getProperty(prop)) || StringUtils.isNotEmpty(System.getenv(env))
    }
}