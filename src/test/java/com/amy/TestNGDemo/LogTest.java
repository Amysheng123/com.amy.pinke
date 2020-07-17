package com.amy.TestNGDemo;

import com.amy.TestData.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public class LogTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class.getName());

    @Test
    public void logTest1() {
        logger.info("1我是info");
    }

    @Test
    public void logTest2() {
        logger.trace("1我是trace");
    }

    @Test
    public void logTest3() {
        logger.debug("1我是debug");
    }

    @Test
    public void logTest4() {
        logger.warn("1我是warn");
    }

    @Test
    public void logTest5() {
        logger.error("1我是error");
    }
}
