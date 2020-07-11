package com.amy.TestNGDemo;

import com.amy.api.Fibonacci;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FibonacciTest {
    @DataProvider(name = "fibo_test_data")
    public Object[][] getFibonacciData(){
        return new Object[][] {
                {1,1},
                {2,1},
                {3,2},
                {6,8},
        };
    }

    @Test(dataProvider = "fibo_test_data")
    public void testFibo(int n, int expected){
        System.out.println("now running fibo....");
        int actual = Fibonacci.fibo(n);
        assertEquals(actual,expected);
    }

    @Test
    public void testFibo_negative(){
        System.out.println("now running fibo_negative....");
        int n = 0;
        try {
            Fibonacci.fibo(0);
        }catch (Exception e) {
            assertTrue(e instanceof ArithmeticException);
            assertEquals(e.getMessage(), "传入参数错误");
        }
    }
}
