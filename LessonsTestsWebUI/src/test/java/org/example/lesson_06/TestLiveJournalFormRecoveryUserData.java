package org.example.lesson_06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestLiveJournalFormRecoveryUserData extends AbstractTest
{
    @Test
    void openFormRecoveryUserData()
    {
        PageLiveJournalFormRecoveryUserData pageLiveJournalFormRecoveryUserData = new PageLiveJournalFormRecoveryUserData(getWebDriver());

        pageLiveJournalFormRecoveryUserData
            .clickButtonCallFormAuthorization()
            .clickLinkPasswordForgot()
            .chooseScenarioLostInfo();

        boolean result = pageLiveJournalFormRecoveryUserData.isExistingFormRecoveryUserDataRequiredElements();

        Assertions.assertTrue(result);
    }

    @Test
    void checkVisibleFormPasswordRecoveryInputNewEmail()
    {
        PageLiveJournalFormRecoveryUserData pageLiveJournalFormRecoveryUserData = new PageLiveJournalFormRecoveryUserData(getWebDriver());

         pageLiveJournalFormRecoveryUserData
             .clickButtonCallFormAuthorization()
             .clickLinkPasswordForgot()
             .chooseScenarioLostPassword()
             .showInputAlternativeEmail();

        boolean result = pageLiveJournalFormRecoveryUserData.isVisibleInputAlternativeEmail();

        Assertions.assertTrue(result);
    }
}
