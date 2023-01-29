package org.example.lesson_03;

import org.openqa.selenium.*;

/**
 * Проверка функционала сайта Live Journal
 * Тест поиска в поисковой строке главной страныцы по категориям с запросом "шкафы"
 */
public class LiveJournalTestMainPageCategorySimpleSearch extends AbstractLiveJournalTest
{
    private static String host = "https://www.livejournal.com/";
    private static String selectorInputSearch = ".search__form input[name=\"q\"]";
    private static String selectorBanner = ".pagewide-wrapper .common-banner";
    private static String selectorButtonSearchSubmit = ".search__form button.search__action";
    private static String searchValue = "шкафы";
    private static String expectedUrl = "https://www.livejournal.com/rsearch?q=шкафы";

    public static void main(String[] args)
    {
        driverSetup();
        openPage(host);

        // Прокрутка с траницы у поисковой строке
        try
        {
            moveToElement(selectorInputSearch);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Ввод значения в поле поиска
        try
        {
            setInputValue(selectorInputSearch, searchValue);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        // Клик по кнопке поиска
        try
        {
            click(selectorButtonSearchSubmit);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        try
        {
            awaitUntilRedirectTo(expectedUrl, 5);
        }
        catch (TimeoutException e)
        {
            System.out.println(e.getSupportUrl());
            System.out.println(e);
            driverQuit();
        }

        driverQuit();
        System.out.println("Тест \"Тест поиска по категориям с запросом - шкафы\" пройден успешно");
    }
}
