package com.amy.TestNGDemo;

import com.amy.TestData.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class WebTest extends BaseTest {

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
