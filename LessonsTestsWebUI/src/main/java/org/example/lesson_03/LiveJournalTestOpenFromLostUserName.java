package org.example.lesson_03;

import org.openqa.selenium.*;

/**
 * Тест открытия формы восстановления имени пользователя
 */
public class LiveJournalTestOpenFromLostUserName extends AbstractLiveJournalTest
{
    private static String host = "https://www.livejournal.com/";
    private static String selectorButtonAuthorization = ".s-header-item__link--login";
    private static String selectorLinkPasswordForgot = "form.b-loginform__form a.b-loginform__link[title=\"Забыли пароль?\"]";
    private static String selectorRadioChooseLostInfo = "label[for=\"lostusername\"]";
    private static String selectorButtonSubmitChooseLostInfo = "input[name=\"next\"]";
    private static String selectorInputEmail = "#email_u";
    private static String selectorInputSubmit = "#lostusername[type=\"submit\"]";

    public static void main(String[] args)
    {
        driverSetup();
        openPage(host);

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

        // Проверка наличия полей email и кнопки submit в форме восстановления имени пользователя
        try
        {
            findElementByCssClass(selectorInputEmail);
            findElementByCssClass(selectorInputSubmit);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
            System.out.println(e.getSupportUrl());
            driverQuit();
        }

        driverQuit();
        System.out.println("Тест \"Смена категорий клоком на управляюще элементы навигационной панели\" пройден успешно");
    }
}
