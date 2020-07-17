package com.amy.TestNGDemo;


import com.amy.TestData.BaseTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Demo1 extends BaseTest {
    @Test
    public void Test11(){
        System.out.println("now running test11....");
        int x = 1, y = 2;
        int expected = 3;
        int actual = x + y;
        assertEquals(actual,expected);
    }

 //   @Ignore
    @Test
    public void Test12(){
        System.out.println("now running test12....");
        int x = 1, y = 2;
        int expected = 4;
        int actual = x + y;
        assertEquals(actual,expected);
    }
}
