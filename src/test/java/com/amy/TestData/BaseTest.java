package com.amy.TestData;

import com.amy.utils.DriverServiceUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected  WebDriver driver;
    protected static String BROWSER = "browser";
    protected static String WAITTIME = "waitTime";


    @BeforeMethod
    public void initDriver(){
        logger.info("开始测试之前启动浏览器");
        driver = DriverServiceUtils.getDriver(ConfigReader.getConfig(BROWSER));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getConfig(WAITTIME)), TimeUnit.SECONDS);

    }
    @AfterMethod
    public void closeDriver(){
        logger.info("关闭浏览器");
        driver.close();
    }
    @AfterSuite
    public void stopService(){
        logger.info("停止服务");
        DriverServiceUtils.stopService();
    }
}
