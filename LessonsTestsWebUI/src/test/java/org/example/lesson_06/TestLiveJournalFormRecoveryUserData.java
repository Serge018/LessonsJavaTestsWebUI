package org.example.lesson_06;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Story("Восстановление данных пользоватедя")
public class TestLiveJournalFormRecoveryUserData extends AbstractTest
{
    @Test
    @DisplayName("Открытие формы восстановления пароля")
    @Link("http://google.com")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Проверка отображения поля ввода альтернативного email в форме восстановления логина")
    @Link("http://google.com")
    @Severity(SeverityLevel.MINOR)
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
