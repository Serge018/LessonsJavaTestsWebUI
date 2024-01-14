package org.example.lesson_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageLiveJournalFormRecoveryUserData extends AbstractPage
{
    static Logger logger = LoggerFactory.getLogger(PageLiveJournalFormRecoveryUserData.class);

    @FindBy(css = "#current_email")
    private static WebElement checkBoxCurrentEmail;

    @FindBy(css = "label[for=\"lostusername\"]")
    private static WebElement radioChooseLostInfo;

    @FindBy(css = "label[for=\"lostpassword\"]")
    private static WebElement radioChooseLostPassword;

    @FindBy(css = "input[name=\"next\"]")
    private static WebElement buttonSubmitChooseLostInfo;

    @FindBy(css = ".s-header-item__link--login")
    private static WebElement buttonCallFormAuthorization;

    @FindBy(css = "form.b-loginform__form a.b-loginform__link[href=\"https://www.livejournal.com/lostinfo.bml\"]")
    private static WebElement linkPasswordForgot;

    private static String selectorInputEmail = "#email_u";
    private static String selectorInputSubmit = "#lostusername[type=\"submit\"]";
    private static String selectorInputAlternativeEmail = "#email_p";


    public PageLiveJournalFormRecoveryUserData(WebDriver driver)
    {
        super(driver);
    }


    public PageLiveJournalFormRecoveryUserData clickButtonCallFormAuthorization()
    {
        buttonCallFormAuthorization.click();

        return this;
    }


    public PageLiveJournalFormRecoveryUserData clickLinkPasswordForgot()
    {
        linkPasswordForgot.click();

        return this;
    }


    public PageLiveJournalFormRecoveryUserData chooseScenarioLostPassword()
    {
        radioChooseLostPassword.click();
        buttonSubmitChooseLostInfo.click();

        return this;
    }


    public PageLiveJournalFormRecoveryUserData showInputAlternativeEmail()
    {
        checkBoxCurrentEmail.click();

        return this;
    }


    public boolean isVisibleInputAlternativeEmail()
    {
         WebDriver driver = getDriver();

        try
        {
            driver.findElement(By.cssSelector(selectorInputAlternativeEmail));

            return true;
        }
        catch (NoSuchElementException e)
        {
            logger.error("В форме восстановления пароля отсутствует поле для ввода альтернативного email - " + selectorInputAlternativeEmail);

            return false;
        }
    }


    public PageLiveJournalFormRecoveryUserData chooseScenarioLostInfo()
    {
        radioChooseLostInfo.click();
        buttonSubmitChooseLostInfo.click();

        return this;
    }


    public boolean isExistingFormRecoveryUserDataRequiredElements()
    {
        WebDriver driver = getDriver();

        try
        {
            driver.findElement(By.cssSelector(selectorInputEmail));
        }
        catch (NoSuchElementException e)
        {
            logger.error("В форме восстановления имени пользователя отсутствует поле для ввода email - " + selectorInputEmail);

            return false;
        }

        try
        {
            driver.findElement(By.cssSelector(selectorInputSubmit));
        }
        catch (NoSuchElementException e)
        {
            logger.error("В форме восстановления имени пользователя отсутствует кнопка submit - " + selectorInputSubmit);

            return false;
        }

        return true;
    }
}