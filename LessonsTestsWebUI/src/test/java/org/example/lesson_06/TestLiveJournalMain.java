package org.example.lesson_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLiveJournalMain extends AbstractTest
{
    @Test
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
    void searchByCategory()
    {
        PageLiveJournalMain pageLiveJournalMain = new PageLiveJournalMain(getWebDriver());

        pageLiveJournalMain
            .moveToCategorySearchString()
            .searchSimpleByCategory();

        Assertions.assertEquals(PageLiveJournalMain.expectedUrlBySearchSimple, getWebDriver().getCurrentUrl());
    }


    @Test
    void chooseLangEnglish() throws InterruptedException {
        PageLiveJournalMain pageLiveJournalMain = new PageLiveJournalMain(getWebDriver());
        pageLiveJournalMain.chooseLangEnglish();

        boolean result = pageLiveJournalMain.isUsedLangEnglish();

        Assertions.assertTrue(result);
    }
}
