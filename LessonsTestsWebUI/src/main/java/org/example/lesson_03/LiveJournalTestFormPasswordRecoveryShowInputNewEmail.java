package org.example.lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Проверка функционала сайта Live Journal
 * Тест формы восстановления пароля. Отображение поля для ввода дополнительго email
 */
public class LiveJournalTestFormPasswordRecoveryShowInputNewEmail
{
    private static ChromeDriver driver;
    private static String host = "https://www.livejournal.com/";

    // Селекторы
    private static String selectorButtonAuthorization = ".s-header-item__link--login";
    private static String selectorLinkPasswordForgot = "form.b-loginform__form a.b-loginform__link[title=\"Забыли пароль?\"]";
    private static String selectorRadioChooseLostInfo = "label[for=\"lostpassword\"]";
    private static String selectorButtonSubmitChooseLostInfo = "input[name=\"next\"]";
    private static String selectorCheckBoxCurrentEmail = "input#current_email[type=\"checkbox\"]";
    private static String selectorInputAlternativeEmail = "#email_p";

    public static void main(String[] args)
    {
        driverSetup();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(host);

        WebElement buttonAuthorization;
        WebElement linkPasswordForgot;
        WebElement radioChooseLostInfo;
        WebElement buttonSubmitChooseLostInfo;
        WebElement checkBoxCurrentEmail;
        WebElement inputAlternativeEmail;

        // Открытие формы авторизации
         try {
            buttonAuthorization = driver.findElement(By.cssSelector(selectorButtonAuthorization));
            buttonAuthorization.click();
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

         // Пеерход на страницу выбора сценария восстановления данных
         try {
            linkPasswordForgot = driver.findElement(By.cssSelector(selectorLinkPasswordForgot));
            linkPasswordForgot.click();
        } catch (NoSuchElementException e){
            System.out.println(e);
            System.out.println(e.getSupportUrl());
            driverQuit();
        }

        // Выбор сценария восстановления пароля
        try {
            radioChooseLostInfo = driver.findElement(By.cssSelector(selectorRadioChooseLostInfo));
            buttonSubmitChooseLostInfo = driver.findElement(By.cssSelector(selectorButtonSubmitChooseLostInfo));

            radioChooseLostInfo.click();
            buttonSubmitChooseLostInfo.click();
        } catch (NoSuchElementException e){
            System.out.println(e);
            System.out.println(e.getSupportUrl());
            driverQuit();
        }

        // Отображение поля для ввода дополнительго email
        try {
            checkBoxCurrentEmail = driver.findElement(By.cssSelector(selectorCheckBoxCurrentEmail));
            checkBoxCurrentEmail.click();

            inputAlternativeEmail = driver.findElement(By.cssSelector(selectorInputAlternativeEmail));
            inputAlternativeEmail.click();
        } catch (NoSuchElementException e){
            System.out.println(e);
            System.out.println(e.getSupportUrl());
        }

        driverQuit();
        System.out.println("Тест \"Отображение поля для ввода дополнительго email\" пройден успешно");
    }


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
    }


    /**
     * Закрытие браузера
     */
    public static void driverQuit()
    {
        driver.quit();
    }

}
