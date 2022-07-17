package org.cecil.spockselenium.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import spock.lang.Specification

/**
 * A sample test exercising the endpoint on an actual servlet
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerRestSpec extends Specification {

    @Autowired
    private TestRestTemplate restTemplate

    @LocalServerPort
    private int port

    def "should return 200 with hello world body"() {
        expect:
        restTemplate.getForObject("http://localhost:${port}/hello/world", String).contains("Hello, world")
    }
}
