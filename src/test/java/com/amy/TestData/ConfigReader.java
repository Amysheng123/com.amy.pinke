package com.amy.TestData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;
    static {
        prop = new Properties();
        InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("test.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getConfig(String name) {
        return prop.getProperty(name);
    }
}
