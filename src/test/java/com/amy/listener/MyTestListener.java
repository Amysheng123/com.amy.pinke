package com.amy.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import sun.awt.geom.AreaOp;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTestListener extends TestListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MyTestListener.class);
/*    @Override
    public void onStart(ITestContext testContext){
        ITestNGMethod[] methods = testContext.getAllTestMethods();
        System.out.println("----->以下是将要运行的方法<---------");
        for(ITestNGMethod method : methods) {
            method.setRetryAnalyzer(new MyRetryAnalyze(2));
            String name = method.getMethodName();
            System.out.println(name);;
        }
        super.onStart(testContext);
    }*/

    @Override
    public void onTestFailure(ITestResult tr) {
        String className = tr.getTestClass().getName();
        String methodName = tr.getName();
        //1. 通过反射，从当前的测试类中取出当前运行的浏览器对应的driver对象
        Object currentTestObject = tr.getInstance(); //获取当前正在运行的测试类的实例；
        Class<?> currentTestClass = tr.getTestClass().getClass().getSuperclass(); // 获取当前运行的测试类；
        try {
            Field webDriverField = currentTestClass. getDeclaredField("driver");//获取当前测试类中定义的driver；
            webDriverField.setAccessible(true); //设置该字段可以被访问；
            WebDriver driver = (WebDriver)webDriverField.get(currentTestObject); // 获取driver对象
            // 2. 定义截图的目录和文件名
            File path = new File("target/snapshots");
            if(!path.isDirectory()){
                logger.info(path.getName() + "目录不存在，创建该目录");
                path.mkdir();
            }
            SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd_HH_mm_ss");
            String filename = className + "." + methodName + "_" + data.format(new Date()) + ".png";
            File file = new File(path, filename);
            // 3. 执行截图，并保存
            File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            screen.renameTo(file);


        } catch (NoSuchFieldException e) {
            logger.error("未在测试类" +className + "中找到driver字段， 自动截图功能失败");
            e.printStackTrace();
        } catch ( IllegalAccessException e) {

        }

    }
}
