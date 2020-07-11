package com.amy.api;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, 7, 9, 4, 1};
        for (int i = 0; i < arr.length - 1; i++) {//外层控制比较趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层控制每一趟的比较次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
