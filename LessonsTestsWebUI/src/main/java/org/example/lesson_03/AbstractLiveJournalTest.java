package org.example.lesson_03;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Класс с основными методами тестов
 */
public abstract class AbstractLiveJournalTest
{
    protected static ChromeDriver driver;
    protected static JavascriptExecutor js;

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

        js = (JavascriptExecutor) driver;
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
     * Прокрутка страницы к элементу
     */
    public static void moveToElement(String cssSelector) throws NoSuchElementException
    {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    /**
     * Ввод значения
     */
    public static void setInputValue(String cssSelector, String value) throws NoSuchElementException
    {
        WebElement input = driver.findElement(By.cssSelector(cssSelector));
        input.sendKeys(value);
    }


    /**
     * Клик по элементу с переданным селектором
     */
    public static void click(String cssSelector) throws NoSuchElementException
    {
        WebElement input = driver.findElement(By.cssSelector(cssSelector));
        input.click();
    }


    /**
     * Дожидается перехода на страницу с переданным url
     */
    public static void awaitUntilRedirectTo(String url, Integer seconds) throws TimeoutException
    {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.urlContains(url));
    }


    /**
     * Закрытие браузера
     */
    public static void driverQuit()
    {
        driver.quit();
    }
}
