package com.amy.anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoRunner{
    public static void main(String[] args) {
        RunDemo demo = new RunDemo();
        Method[] methods = RunDemo.class.getDeclaredMethods();
        for(Method method : methods) {
            if(method.getAnnotation(RunNums.class) != null){
                int times = method.getAnnotation(RunNums.class).times();
                for(int i = 0; i < times; i++){
                    try {
                        method.invoke(demo);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

    }

}
