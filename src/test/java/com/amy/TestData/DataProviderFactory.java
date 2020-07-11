package com.amy.TestData;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "registerTestData")
    public static Object[][] getRegisterTestData(){
        return new Object[][]{
                {"eee123456", "eee123456@163.com", "eee123456","eee123456","123456789", "用户名 eee123456 注册成功"},
                {"fff123456", "fff123456@163.com", "fff123456","eee123456","123456789", "- 两次输入密码不一致\n"}
        };
    }
}
