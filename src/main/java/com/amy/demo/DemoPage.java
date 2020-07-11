package com.amy.demo;

import com.amy.ecshop.pages.EcshopIndexPage;
import com.amy.ecshop.pages.EcshopRegisterPage;
import com.amy.utils.DriverServiceUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.util.concurrent.TimeUnit;

public class DemoPage {

    public static void main(String[] args) {
        WebDriver driver = DriverServiceUtils.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("http://localhost/ecshop");
        EcshopIndexPage indexPage = new EcshopIndexPage(driver);
        indexPage.clickRegisterLink();
        EcshopRegisterPage registerPage = new EcshopRegisterPage(driver);
        registerPage.inputUserName("ddd123456");
        registerPage.inputEmail("ddd123456789@163.com");
        registerPage.inputPassword("Asheng123456");
        System.out.println(registerPage.getPasswordStrength());
        registerPage.inputConfirmPassword("Asheng12345");
        registerPage.inputMobileNumber("123456789");
        registerPage.clickRegBtn();
        registerPage.assertAlertText("- 两次输入密码不一致\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        DriverServiceUtils.stopService();


    }
}
