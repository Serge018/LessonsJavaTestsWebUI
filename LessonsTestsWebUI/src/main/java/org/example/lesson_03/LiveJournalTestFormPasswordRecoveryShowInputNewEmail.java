package org.example.lesson_03;

import org.openqa.selenium.*;

/**
 * Проверка функционала сайта Live Journal
 * Тест формы восстановления пароля. Отображение поля для ввода дополнительго email
 */
public class LiveJournalTestFormPasswordRecoveryShowInputNewEmail extends AbstractLiveJournalTest
{
    private static String host = "https://www.livejournal.com/";

    // Селекторы
    private static String selectorButtonAuthorization = ".s-header-item__link--login";
    private static String selectorLinkPasswordForgot = "form.b-loginform__form a.b-loginform__link[title=\"Забыли пароль?\"]";
    private static String selectorRadioChooseLostInfo = "label[for=\"lostpassword\"]";
    private static String selectorButtonSubmitChooseLostInfo = "input[name=\"next\"]";
    private static String selectorCheckBoxCurrentEmail = "#current_email";
    private static String selectorInputAlternativeEmail = "#email_p";

    public static void main(String[] args)
    {
        driverSetup();
        openPage(host);

        WebElement buttonAuthorization;
        WebElement linkPasswordForgot;
        WebElement radioChooseLostInfo;
        WebElement buttonSubmitChooseLostInfo;
        WebElement checkBoxCurrentEmail;
        WebElement inputAlternativeEmail;

        // Открытие формы авторизации
        try
        {
            click(selectorButtonAuthorization);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Пеерход на страницу выбора сценария восстановления данных кликом по ссылке "Забыли пароль"
        try
        {
            click(selectorLinkPasswordForgot);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
            System.out.println(e.getSupportUrl());
            driverQuit();
        }

        // Выбор сценария восстановления пароля
        try
        {
            click(selectorRadioChooseLostInfo);
            click(selectorButtonSubmitChooseLostInfo);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
            System.out.println(e.getSupportUrl());
            driverQuit();
        }

        // Отображение поля для ввода дополнительго email
        try
        {
            click(selectorCheckBoxCurrentEmail);
            click(selectorInputAlternativeEmail);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
            System.out.println(e.getSupportUrl());
        }

        driverQuit();
        System.out.println("Тест \"Отображение поля для ввода дополнительго email\" пройден успешно");
    }
}
