package org.example.lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public abstract class AbstractLiveJournalTest
{
    protected static ChromeDriver driver;

    /**
     * Установка драйвера
     */
    public static void driverSetup ()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    /**
     * Открытие страницы
     */
    public static void openPage(String url)
    {
        driver.get(url);
    }


    /**
     * Закрытие браузера
     */
    public static void driverQuit()
    {
        driver.quit();
    }
}
