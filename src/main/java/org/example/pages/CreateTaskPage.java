package org.example.pages;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class CreateTaskPage extends BasePage {

    public void clickCreateTaskButton(){
        waitPresenceElement(By.id("br.com.todoapp:id/floatingActionButtonCreateTask"));
        click(By.id("br.com.todoapp:id/floatingActionButtonCreateTask"));
    }

    public void createTask(String taskName, String priority){
        waitPresenceElement(By.id("android:id/alertTitle"));
        setField(By.id("br.com.todoapp:id/edit_taskdescription"), taskName);
        click(By.xpath("//*[@text='"+priority+"']"));
        click(By.id("android:id/button1"));
    }

    public boolean isTaskCreated(String taskName){
        waitPresenceElement(By.id("br.com.todoapp:id/txt_description"));
        return scroll(taskName);
    }
}
