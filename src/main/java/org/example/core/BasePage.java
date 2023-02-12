package org.example.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    public void accessAppsList(){
        getDriver().findElement(MobileBy.AccessibilityId("Apps")).click();
    }

    public void accessApp(String appName){
        clickHomePhone();
        accessAppsList();
        scroll(appName);
        clickByText(appName);
    }

    public void click(By by){
        waitClickableElement(by);
        getDriver().findElement(by).click();
    }

    public void clickByText(String text){
        click(By.xpath("//*[@text='"+text+"']"));
    }

    public void clickHomePhone(){
        getDriver().pressKeyCode(AndroidKeyCode.HOME);
    }

    public void implicitlyWait(long time){
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public boolean scroll(String visibleText){
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
        return true;
    }

    public void setField(By by, String text){
        waitPresenceElement(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public void waitClickableElement(By by){
        new WebDriverWait(getDriver(), SleepTime.TEN_SEC).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitPresenceElement(By by){
        new WebDriverWait(getDriver(), SleepTime.TEN_SEC).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
