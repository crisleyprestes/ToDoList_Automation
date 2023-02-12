package org.example.pages;

import io.appium.java_client.MobileElement;
import org.example.core.BasePage;
import org.example.core.SleepTime;
import org.openqa.selenium.By;

import java.util.List;

public class TypesPage extends BasePage {

    public void clickCreateButton(){
        clickButton(By.id("android:id/button1"));
        implicitlyWait(SleepTime.TEN_SEC);
    }

    public void clickCreateTypeButton(){
        clickButton(By.id("br.com.todoapp:id/floatingActionButtonCreate"));
    }

    public boolean isTaskTypeCreated(String text){
        scroll(text);
        return true;
    }

    public void setTaskType(String value){
        setField(By.id("br.com.todoapp:id/edit_tasktype"), value);
    }
}
