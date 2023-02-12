package org.example.lesson_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLiveJournalMain extends AbstractPage
{
    @FindBy(css = "ul.categories__list a[href=\"https://www.livejournal.com/category/novye_lica/\"]")
    private static WebElement linkCategoryNewFaces;

    @FindBy(css = "ul.categories__list a[href=\"https://www.livejournal.com/category/video/\"]")
    private static WebElement linkCategoryVideo;

    @FindBy(css = "ul.categories__list a[href=\"https://www.livejournal.com/category/kino/\"]")
    private static WebElement linkCategoryFilms;

    @FindBy(css = "ul.categories__list a[href=\"https://www.livejournal.com/category/puteshestviya/\"]")
    private static WebElement linkCategoryTravels;

    @FindBy(css = ".search__form input[name=\"q\"]")
    private static WebElement inputSearch;

    @FindBy(css = ".search__form button.search__action")
    private static WebElement buttonSearchSubmit;

    @FindBy(css = ".s-header-item__link--lang")
    private static WebElement buttonDropDownChoiceLang;

    @FindBy(css = ".s-nav-item.s-drop-master.s-nav-item-lang [data-lang=\"en_LJ\"]")
    private static WebElement buttonDropDownChoiceLangItemEnglish;

    @FindBy(xpath = ".//a[text() = 'Log in']")
    private static WebElement buttonCallFormAuthorization;


    public static String expectedUrlCategoryNewFaces = "https://www.livejournal.com/media/novye_lica/";
    public static String expectedUrlCategoryVideo = "https://www.livejournal.com/media/video/";
    public static String expectedUrlCategoryFilms = "https://www.livejournal.com/category/kino/";
    public static String expectedUrlCategoryTravels = "https://www.livejournal.com/category/puteshestviya/";
    public static String expectedUrlBySearchSimple = "https://www.livejournal.com/rsearch?q=%D1%88%D0%BA%D0%B0%D1%84%D1%8B&sort=_score&searchArea=post";
    private static String searchValue = "шкафы";


    private static String buttonCallFormAuthorizationTextInEnglish = "LOG IN";


    public PageLiveJournalMain(WebDriver driver)
    {
        super(driver);
    }


    public PageLiveJournalMain navigateToCategoryNewFaces()
    {
        linkCategoryNewFaces.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlCategoryNewFaces));

        return this;
    }


    public PageLiveJournalMain navigateToCategoryVideo()
    {
        linkCategoryVideo.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlCategoryVideo));

        return this;
    }


    public PageLiveJournalMain navigateToCategoryFilms()
    {
        linkCategoryFilms.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlCategoryFilms));

        return this;
    }


    public PageLiveJournalMain navigateToCategoryTravels()
    {
        linkCategoryTravels.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlCategoryTravels));

        return this;
    }


    public PageLiveJournalMain moveToCategorySearchString()
    {
        moveToElement(inputSearch);

        return this;
    }


    public PageLiveJournalMain searchSimpleByCategory()
    {
        inputSearch.sendKeys(searchValue);
        buttonSearchSubmit.click();

        return this;
    }


    public PageLiveJournalMain chooseLangEnglish()
    {
        buttonDropDownChoiceLang.click();
        buttonDropDownChoiceLangItemEnglish.click();

        return this;
    }


    public boolean isUsedLangEnglish()
    {
        String buttonText = buttonCallFormAuthorization.getText();

        boolean result = buttonCallFormAuthorizationTextInEnglish.equalsIgnoreCase(buttonText);
System.out.println(buttonCallFormAuthorizationTextInEnglish);
System.out.println(buttonText);

        return result;
    }
}
