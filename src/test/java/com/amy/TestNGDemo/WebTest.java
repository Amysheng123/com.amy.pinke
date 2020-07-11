package com.amy.TestNGDemo;

import com.amy.Service.WebDriverServiceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WebTest {
    private WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        driver = WebDriverServiceUtils.getDriver();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
    @AfterSuite
    public void stopService(){
        WebDriverServiceUtils.stopService();
    }

    @Test
    public void testBaidu(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("test");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBaidu02(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("test");
        assertTrue(new WebDriverWait(driver, 10L).until(ExpectedConditions.titleContains("test")));
    }
}
