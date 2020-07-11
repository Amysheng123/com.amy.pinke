package com.amy.api;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class PrimeNumber {

    /**
     * 求1-100之间的素数
     */
    public static void main(String[] args) {
        int[] x = new int[100]; // 定义具有100个元素的数组x

        //循环100次，将0--99赋给x的无素
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        //判断1-99之间的素数，如果是素数，就输出
        for(int i = 1; i < x.length; i++){
            boolean flag = true;
            for(int j = 2; j<x[i]; j++){
                if(x[i]%j == 0){

                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(x[i]);
            }
        }
    }
}
