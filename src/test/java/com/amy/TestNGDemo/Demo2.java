package com.amy.TestNGDemo;


import com.amy.TestData.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Demo2 extends BaseTest {
    @Test
    public void Test21(){
        System.out.println("now running test21....");
        int x = 1, y = 2;
        int expected = 3;
        int actual = x + y;
        assertEquals(actual,expected);
    }
    @Test
    public void Test22(){
        System.out.println("now running test22....");
        int x = 1, y = 2;
        int expected = 4;
        int actual = x + y;
        assertEquals(actual,expected);
    }
}
