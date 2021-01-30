package example.micronaut.services

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import example.micronaut.services.condictions.AwsCredentialsProviderCondition
import io.micronaut.context.annotation.Requires
import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
@Requires(condition = AwsCredentialsProviderCondition::class)
class AwsCredentialsProviderService(
    @param:Value("\${AWS_ACCESS_KEY_ID:none}") val accessKeyEnv: String,
    @param:Value("\${AWS_SECRET_KEY:none}") val secretKeyEnv: String,
    @param:Value("\${aws.accesskeyid:none}") val accessKeyProp: String,
    @param:Value("\${aws.secretkey:none}") val secretKeyProp: String
) : AWSCredentialsProvider {

    val accessKey: String
    val secretKey: String

    init {
        accessKey = if (accessKeyEnv != "none") accessKeyEnv else accessKeyProp
        secretKey = if (secretKeyEnv != "none") secretKeyEnv else secretKeyProp
    }

    override fun refresh() {
        TODO("Not yet implemented")
    }

    override fun getCredentials(): AWSCredentials {
        return BasicAWSCredentials(accessKey, secretKey)
    }
}