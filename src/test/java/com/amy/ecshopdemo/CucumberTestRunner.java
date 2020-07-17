package com.amy.ecshopdemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.amy.ecshop.cucumber.steps"},
        monochrome = true,
        plugin = {"html:target/cucumber-report/html", "json:target/cucumber-report/json/cucumber-report.json"}

)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
