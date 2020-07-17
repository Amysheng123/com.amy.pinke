package com.amy.ecshop.cucumber.steps;

import com.amy.ecshop.pages.EcshopIndexPage;
import com.amy.ecshop.pages.EcshopRegisterPage;
import com.amy.utils.DriverServiceUtils;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class RegisterTestSteps {

    private WebDriver driver;
    private EcshopIndexPage index;
    private EcshopRegisterPage register;


    @And("^打开首页\"([^\"]*)\"$")
    public void open_index_page(String url) {
        driver = DriverServiceUtils.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(url);
        index = new EcshopIndexPage(driver);

    }

    @And("^点击免费注册按钮$")
    public void click_reg_click() {
        index.clickRegisterLink();
        register = new EcshopRegisterPage(driver);
    }

    @And("^填写用户名\"([^\"]*)\"$")
    public void input_username(String username) {
        register.inputUserName(username);
    }

    @And("^填写邮箱\"([^\"]*)\"$")
    public void input_email(String email) {
        register.inputEmail(email);
    }

    @And("^填写密码\"([^\"]*)\"$")
    public void input_password(String password) {
        register.inputPassword(password);
    }

    @And("^填写确认密码\"([^\"]*)\"$")
    public void input_confirmpassword(String confirmpassword) {
        register.inputConfirmPassword(confirmpassword);
    }

    @And("^填写手机号\"([^\"]*)\"$")
    public void input_mobilenumber(String mobileNumber) {
        register.inputMobileNumber(mobileNumber);
    }

    @And("^点击注册按钮$")
    public void click_reg_btn(){
        register.clickRegBtn();
    }

    @And("^页面跳转显示\"([^\"]*)\"$")
    public void assert_success(String expectedMsg) {
        register.assertRegisterResult(expectedMsg);
    }

    @And("^关闭浏览器$")
    public void close_driver() {
        driver.close();
        DriverServiceUtils.stopService();
    }
}
