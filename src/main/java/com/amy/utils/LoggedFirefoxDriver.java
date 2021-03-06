package com.amy.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoggedFirefoxDriver extends FirefoxDriver {

    private static final Logger logger = LoggerFactory.getLogger(LoggedFirefoxDriver.class);

    public LoggedFirefoxDriver() {
        super();
    }

    public LoggedFirefoxDriver(GeckoDriverService service, FirefoxOptions options) {
        super(service, options);
    }

    @Override
    protected WebElement findElement(String by, String using) {
        WebElement element = null;
        try {
            element = super.findElement(by, using);
            logger.info("使用"+ by + ": " + using + "， 找到元素");
        }catch (NoSuchElementException e) {
            logger.error("使用"+ by + ": " + using + "， 未找到元素");
            throw e;
        }
        return element;
    }

    @Override
    protected List<WebElement> findElements(String by, String using) {
        List<WebElement> elements = null;
        try {
            elements = super.findElements(by, using);
            logger.info("使用" + by +": " + using +"， 找到" + elements.size() + "个元素");
        } catch (NoSuchElementException e) {
            logger.error("使用" + by +": " + using +"， 未找到元素");
            throw e;
        }
        return elements;
    }
}
