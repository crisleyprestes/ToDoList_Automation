package org.example.core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    public void clickButton(By by){
        waitElement(by);
        getDriver().findElement(by).click();
    }

    public void setField(By by, String text){
        waitElement(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public boolean waitElement(By by){
        new WebDriverWait(getDriver(), SleepTime.TEN_SEC).until(ExpectedConditions.presenceOfElementLocated(by));
        return true;
    }
}
