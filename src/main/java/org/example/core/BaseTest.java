package org.example.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.example.core.DriverFactory.getDriver;
import static org.example.core.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void closeClass(){
        killDriver();
    }

    @After
    public void tearDown(){
        takeScreenshot();
        getDriver().resetApp();
    }

    public void takeScreenshot(){
        File image = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(image, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
