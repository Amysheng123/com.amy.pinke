package com.amy.TestNGDemo;

import com.amy.utils.DriverServiceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDemo3 {
    private WebDriver driver;

    @BeforeMethod
    public void getDriver(){
        driver = DriverServiceUtils.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void stopDriver(){
        driver.close();
    }

    @AfterClass
    public void stopService(){
        DriverServiceUtils.stopService();
    }

    @Test
    public void testDriver(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("test");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
