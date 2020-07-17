package com.amy.TestNGDemo;


import com.amy.TestData.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLog extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoLog.class.getName());

    public static void main(String[] args) {

        logger.error("hahaha");
    }

}
