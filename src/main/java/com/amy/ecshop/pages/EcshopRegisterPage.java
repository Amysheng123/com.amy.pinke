package com.amy.ecshop.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;

import java.util.List;

import static org.jsoup.helper.Validate.fail;

public class EcshopRegisterPage {
    private static final Logger logger = LoggerFactory.getLogger(EcshopRegisterPage.class.getName());

    private WebDriver driver;

    public static final String PASSWORD_STRONG = "强";
    public static final String PASSWORD_MIDDLE = "中";
    public static final String PASSWORD_WEAK = "弱";

    private static final String GRAY_STYLE = "border-bottom: 2px solid rgb(218, 218, 218);";

    @FindBy(name="username")
    private WebElement username_ipt;

    @FindBy(name = "email")
    private WebElement email_ipt;

    @FindBy(name = "password")
    private WebElement password_ipt;

    @FindBy(name = "confirm_password")
    private WebElement confirm_password_ipt;

    @FindBy(name = "extend_field2")
    private WebElement extend_field2_ipt;  // QQ号码


    @FindBy(name = "extend_field3")
    private WebElement extend_field3_ipt; // 办公号码

    @FindBy(name = "extend_field4")
    private WebElement extend_field4_ipt; // 家庭号码

    @FindBy(name = "extend_field5")
    private WebElement extend_field5_ipt; // 手机

    @FindBy(name = "sel_question")
    private WebElement sel_question_select;

    @FindBy(name = "passwd_answer")
    private WebElement passwd_answer_ipt;

    @FindBy(xpath = "//td[text()='密码强度']/../td[2]/table/tbody/tr/td")
    private List<WebElement> password_strength_list;

    @FindBy(name = "Submit")
    private WebElement submit;

    @FindBy(xpath = "//h3/../div/div/p")
    private WebElement result_p;


    public EcshopRegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement inputUserName(String username) {
        logger.info("输入用户名");
        username_ipt.sendKeys(username);
        fireOnBlur(username_ipt);
        return username_ipt.findElement(By.xpath("../span"));
    }

    public  WebElement inputEmail(String email) {
        logger.info("输入邮箱");
        email_ipt.sendKeys(email);
        fireOnBlur(email_ipt);
        return email_ipt.findElement(By.xpath("../span"));
    }

    public WebElement inputPassword(String password) {
        logger.info("输入密码");
        password_ipt.sendKeys(password);
        fireOnBlur(password_ipt);
        return password_ipt.findElement(By.xpath("../span"));
    }

    public WebElement inputConfirmPassword(String confirmpassword) {
        logger.info("确认密码");
        confirm_password_ipt.sendKeys(confirmpassword);
        fireOnBlur(confirm_password_ipt);
        return confirm_password_ipt.findElement(By.xpath("../span"));
    }

    public WebElement inputMobileNumber(String number) {
        logger.info("输入手机号码");
        extend_field5_ipt.sendKeys(number);
        fireOnBlur(extend_field5_ipt);
        return extend_field5_ipt.findElement(By.xpath("../span"));
    }

    public String getPasswordStrength(){
        logger.info("获取密码强度");
        for(WebElement item : password_strength_list){
            String style = item.getAttribute("style");
            if(!style.equals(GRAY_STYLE)) {
                return item.getText();
            }

        }
        return "";
    }

    public void clickRegBtn(){
        logger.info("确认提交注册信息");
        submit.click();
    }

    public void assertAlertText(String expectedMsg){
        Alert alert = new WebDriverWait(driver,5L).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            fail("并未弹出警告框");
            logger.warn("没有弹出警告框");
        }
        String actualMsg = alert.getText();
        alert.accept();
        assertEquals(actualMsg, expectedMsg);
    }

    public void assertRegisterResult(String expectedMsg){
        String actualMsg = result_p.getText();
        assertEquals(actualMsg, expectedMsg);
    }


    private void  fireOnBlur(WebElement element) {
        element.findElement(By.xpath("../../td[1]")).click();
    }

}
