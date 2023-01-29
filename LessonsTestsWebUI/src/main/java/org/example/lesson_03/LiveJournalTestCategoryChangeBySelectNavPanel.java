package org.example.lesson_03;

import org.openqa.selenium.*;

/**
 * Тест смены категорий кликом на управляюще элементы навигационной панели
 */
public class LiveJournalTestCategoryChangeBySelectNavPanel extends AbstractLiveJournalTest
{
    private static String host = "https://www.livejournal.com/";

    private static String selectorLinkCategoryNewFaces = "ul.categories__list a[href=\"https://www.livejournal.com/category/novye_lica/\"]";
    private static String selectorLinkCategoryVideo = "ul.categories__list a[href=\"https://www.livejournal.com/category/video/\"]";
    private static String selectorLinkCategoryFilms = "ul.categories__list a[href=\"https://www.livejournal.com/category/kino/\"]";
    private static String selectorLinkCategoryHealth = "ul.categories__list a[href=\"https://www.livejournal.com/category/zdorove/\"]";

    private static String expectedUrlCategoryNewFaces = "https://www.livejournal.com/media/novye_lica/";
    private static String expectedUrlCategoryVideo = "https://www.livejournal.com/media/video/";
    private static String expectedUrlCategoryFilms = "https://www.livejournal.com/category/kino/";
    private static String expectedUrlCategoryHealth = "https://www.livejournal.com/category/zdorove/";

    public static void main(String[] args)
    {
        driverSetup();
        openPage(host);

        // Проверка перехода при клике по пункту "Новые лица" в навигационной панели
        try
        {
            click(selectorLinkCategoryNewFaces);
            awaitUntilRedirectTo(expectedUrlCategoryNewFaces, 5);
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Проверка перехода при клике по пункту "Видео" в навигационной панели
        try
        {
            click(selectorLinkCategoryVideo);
            awaitUntilRedirectTo(expectedUrlCategoryVideo, 5);
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Проверка перехода при клике по пункту "Кино" в навигационной панели
        try
        {
            click(selectorLinkCategoryFilms);
            awaitUntilRedirectTo(expectedUrlCategoryFilms, 5);
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Проверка перехода при клике по пункту "Здоровье" в навигационной панели
        try
        {
            click(selectorLinkCategoryHealth);
            awaitUntilRedirectTo(expectedUrlCategoryHealth, 5);
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        driverQuit();
        System.out.println("Тест \"Смена категорий клоком на управляюще элементы навигационной панели\" пройден успешно");
    }
}
