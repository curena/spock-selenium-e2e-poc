package org.cecil.spockselenium.api

import org.awaitility.Awaitility
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import spock.lang.Specification

import java.time.Duration
import java.time.temporal.ChronoUnit

import static org.hamcrest.Matchers.is

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldSeleniumSpec extends Specification {
    private static WebDriver driver
    @LocalServerPort
    private int port

    def setupSpec() {
        System.setProperty("webdriver.chrome.driver", "/Users/curena/Downloads/chromedriver")
        driver = new ChromeDriver()
    }

    def cleanupSpec() {
        if (driver != null) {
            driver.close()
        }
    }

    def "google query should return appropriate title"() {
        given:
        driver.navigate().to("https://www.google.com")
        WebElement searchBox = driver.findElement(By.cssSelector("input[name=q]"))
        WebElement submitSearchButton = driver.findElement(By.cssSelector("input[name=btnK]"))
        when:
        searchBox.sendKeys("foo")
        Awaitility.await("wait for searchBox to be displayed").atMost(Duration.of(5L, ChronoUnit.SECONDS))
                  .until(submitSearchButton::isDisplayed, is(true))
        submitSearchButton.click()
        def title = driver.getTitle()
        then:
        title.toLowerCase() contains("foo")
    }

    def "exercising hello world should return 200 with body 'Hello, world'"() {
        given:
        driver.navigate().to("http://localhost:${port}/hello/world")
        def body = driver.findElement(By.tagName("body"))
        expect:
        body.getText() == "Hello, world"


    }
}
