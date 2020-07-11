package com.amy.Service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.ServiceConfigurationError;

public class WebDriverServiceUtils {
    private static DriverService service;
    private static ChromeOptions option;
    static {
        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .usingDriverExecutable(new File("C:\\Amy\\Automation\\chromedriver\\chromedriver.exe"))
                .build();
        option = new ChromeOptions();
        option.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        option.setAcceptInsecureCerts(true);

    }

    public static ChromeDriver getDriver() {
        return new ChromeDriver((ChromeDriverService)service);

    }

    public static void stopService() {
        service.stop();
    }
}
