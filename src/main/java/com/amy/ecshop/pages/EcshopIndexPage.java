package com.amy.ecshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EcshopIndexPage {
    private static final Logger logger = LoggerFactory.getLogger(EcshopRegisterPage.class.getName());

    @FindBy(linkText="免费注册")
    private WebElement register_link;

    @FindBy(linkText = "请登录 ")
    private WebElement login_link;

    public void clickRegisterLink(){
        logger.info("点击注册");
        register_link.click();
    }

    public void clickLoginLink(){
        logger.info("点击登录");
        login_link.click();
    }

    public EcshopIndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
