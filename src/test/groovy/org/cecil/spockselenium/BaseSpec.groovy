package org.cecil.spockselenium

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.ConfigurableEnvironment
import spock.lang.Specification

@SpringBootTest
class BaseSpec extends Specification {
    @Autowired
    ConfigurableEnvironment configurableEnvironment

    def "should load context"() {
        expect:
        configurableEnvironment != null
    }
}
