package com.amy.TestNGDemo;

import com.amy.demo.Calc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Iterator;

import static org.testng.Assert.assertEquals;

public class CalcTest {
    private Calc calc;
    @BeforeClass
    public void init(){
        calc = new Calc();
    }
    @DataProvider(name = "calc_data")
    public Object [][] calcTestData() {
        Object[][] objs = new Object[][]{
                {1,10, 20, 30},
                {2,20, 20, 40},
                {3,20, 30, 50}
        };
        return objs;
    }
//@DataProvider(name = "dataForRule")
//public Iterator<Object[]> dataForCheckRule(Method method) throws FileNotFoundException {
//    String testCase=this.getClass().getSimpleName();
//    String excelFile= PropHelper.getProperty("testData.dir").trim() +testCase+"/"+testCase+".xls";
//    return new ExcelDataProvider(excelFile);
//}


    @Test(dataProvider= "calc_data")
    public void Test1(int caseId, int x, int y, int expected){
        int actual = calc.compute(x, y);
        assertEquals(actual, expected);
    }
}
