package org.example.lesson_06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage
{
    private WebDriver driver;
    protected JavascriptExecutor js;


    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }


    protected void moveToElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    protected WebDriver getDriver()
    {
        return this.driver;
    }
}
