package org.example.lesson_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AbstractTest
{
     static WebDriver webDriver;
     static int implicitlyWait = 10;
     static int pageWaitLoadDuration = 10;
     static String host = "https://www.livejournal.com/";


     @BeforeAll
    static void setDriver()
     {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(pageWaitLoadDuration));

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }


    @BeforeEach
    void initMainPage()
    {
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to(host),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }


    @AfterAll
    public static void exit()
    {
        if(webDriver != null)
        {
            webDriver.quit();
        }
    }


    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }
}
