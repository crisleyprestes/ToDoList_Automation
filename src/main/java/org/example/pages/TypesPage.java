package org.example.pages;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class TypesPage extends BasePage {

    public void clickCreateButton(){
        clickButton(By.id("android:id/button1"));
    }

    public void clickCreateTypeButton(){
        clickButton(By.id("br.com.todoapp:id/floatingActionButtonCreate"));
    }

    public void setTaskType(String value){
        setField(By.id("br.com.todoapp:id/edit_tasktype"), value);
    }
}
