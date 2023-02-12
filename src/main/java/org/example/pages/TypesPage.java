package org.example.pages;

import org.example.core.BasePage;
import org.example.core.SleepTime;
import org.openqa.selenium.By;

public class TypesPage extends BasePage {

    public void clickCreateButton(){
        click(By.id("android:id/button1"));
        implicitlyWait(SleepTime.TEN_SEC);
    }

    public void clickCreateTypeButton(){
        click(By.id("br.com.todoapp:id/floatingActionButtonCreate"));
    }

    public void clickTaskType(String text) {
        accessApp("TODO LIST");
        scroll(text);
        click(By.xpath("//*[@text='"+text+"']"));
    }

    public boolean createNewTaskType(String text){
        clickCreateTypeButton();
        setTaskType(text);
        clickCreateButton();
        return true;
    }

    public void setTaskType(String value){
        setField(By.id("br.com.todoapp:id/edit_tasktype"), value);
    }
}
