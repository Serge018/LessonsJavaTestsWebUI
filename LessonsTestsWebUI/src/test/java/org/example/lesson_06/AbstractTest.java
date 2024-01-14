package org.example.lesson_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

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

    @AfterEach
    public void tearDown()
    {
        // Вывод всех ошибок браузера после каждого теста
        LogEntries browserLogs = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0 )
        {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }
    }


    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }
}
