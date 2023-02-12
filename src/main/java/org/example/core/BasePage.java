package org.example.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    public void clickButton(By by){
        waitElement(by);
        getDriver().findElement(by).click();
    }

    public List<MobileElement> getList(By by){
        List<MobileElement> list = getDriver().findElements(by);
        return list;
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public void implicitlyWait(long time){
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void scroll(String visibleText){
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
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
