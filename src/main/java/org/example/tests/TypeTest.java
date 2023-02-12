package org.example.tests;

import org.example.core.BaseTest;
import org.example.pages.CreateTaskPage;
import org.example.pages.TypesPage;
import org.junit.Assert;
import org.junit.Test;

public class TypeTest extends BaseTest {

    private CreateTaskPage createTaskPage = new CreateTaskPage();
    private TypesPage typesPage = new TypesPage();

    @Test
    public void createNewTaskType(){
        typesPage.createNewTaskType("FPF");
        Assert.assertTrue(typesPage.scroll("FPF"));
    }

    @Test
    public void createNewTask(){
        typesPage.createNewTaskType("FPF");
        typesPage.clickTaskType("FPF");
        createTaskPage.clickCreateTaskButton();
        createTaskPage.createTask("prova", "Baixo");
        Assert.assertTrue(createTaskPage.isTaskCreated("prova"));
    }
}
