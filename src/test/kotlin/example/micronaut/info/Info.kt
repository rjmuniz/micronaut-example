package example.micronaut.info

import io.micronaut.core.annotation.Introspected


@Introspected
class Info {
    var git: GitInfo? = null

}