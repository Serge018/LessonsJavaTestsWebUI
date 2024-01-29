package org.example.lesson_06;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Тесты главной страницы сайта www.livejournal.com")
public class TestLiveJournalMain extends AbstractTest
{
    @Test
    @DisplayName("Переход по категориям сайта с помощью главной навигационной панели")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
    void navigationNavPanel()
    {
        PageLiveJournalMain pageLiveJournalMain = new PageLiveJournalMain(getWebDriver());

        pageLiveJournalMain
            .navigateToCategoryNewFaces()
            .navigateToCategoryVideo()
            .navigateToCategoryFilms()
            .navigateToCategoryTravels();

        Assertions.assertEquals(PageLiveJournalMain.expectedUrlCategoryTravels, getWebDriver().getCurrentUrl());
    }


    @Test
    @DisplayName("Проверка поиска в категориях с помощью главной поисковой строки")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
    void searchByCategory()
    {
        PageLiveJournalMain pageLiveJournalMain = new PageLiveJournalMain(getWebDriver());

        pageLiveJournalMain
            .moveToCategorySearchString()
            .searchSimpleByCategory();

        String currentUrl = getWebDriver().getCurrentUrl();
        boolean hasCurrentUrlExpectedSearchParameter = currentUrl.contains(PageLiveJournalMain.expectedUrlSearchParameter);

        Assertions.assertTrue(hasCurrentUrlExpectedSearchParameter);
    }


    @Test
    @DisplayName("Переключение языка на английский")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
    void chooseLangEnglish() throws InterruptedException {
        PageLiveJournalMain pageLiveJournalMain = new PageLiveJournalMain(getWebDriver());
        pageLiveJournalMain.chooseLangEnglish();

        boolean result = pageLiveJournalMain.isUsedLangEnglish();

        Assertions.assertTrue(result);
    }
}
