package com.amy.ecshopdemo;


import com.amy.TestData.DataProviderFactory;
import com.amy.ecshop.pages.EcshopIndexPage;
import com.amy.ecshop.pages.EcshopRegisterPage;
import com.amy.TestData.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class EcshopRegisterPageTest extends BaseTest {

    @Test(dataProvider = "registerTestData", dataProviderClass = DataProviderFactory.class)
    public void testRegisterSuccess(String name, String email, String password, String confirmPassword, String mobileNumber, String expectedMsg){
        logger.info("打开测试网页执行测试用例-success");
        driver.get("http://localhost/ecshop");
        EcshopIndexPage indexPage = new EcshopIndexPage(driver);
        indexPage.clickRegisterLink();
        EcshopRegisterPage registerPage = new EcshopRegisterPage(driver);
        registerPage.inputUserName(name);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(confirmPassword);
        registerPage.inputMobileNumber(mobileNumber);
        registerPage.clickRegBtn();
        registerPage.assertRegisterResult(expectedMsg);

    }

    @Test
    public void testRegisterNameExist(){
        logger.info("测试用例-name存在");
        driver.get("http://localhost/ecshop");
        EcshopIndexPage indexPage = new EcshopIndexPage(driver);
        indexPage.clickRegisterLink();
        EcshopRegisterPage registerPage = new EcshopRegisterPage(driver);
        WebElement text_element = registerPage.inputUserName("bbb123456");
        assertTrue(new WebDriverWait(driver, 5L).until(ExpectedConditions.textToBePresentInElement(text_element, "* 用户名已经存在,请重新输入")));



    }


}
