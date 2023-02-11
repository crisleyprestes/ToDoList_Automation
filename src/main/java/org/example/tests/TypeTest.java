package org.example.tests;

import org.example.core.BaseTest;
import org.example.pages.TypesPage;
import org.junit.Test;

public class TypeTest extends BaseTest {

    private TypesPage typesPage = new TypesPage();

    @Test
    public void createNewTaskType(){
        typesPage.clickCreateTypeButton();
        typesPage.setTaskType("FPF");
        typesPage.clickCreateButton();
    }
}
