package com.example.arithmetic.geektime.wangzheng.sort;

/**
 * 冒泡、插入、选择
 */
public class BuleInsertSlect3 {

    public static void maopao(int a[]) {
        if (a == null) {
            return;
        }
        int n = a.length;
        if (n <= 1) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void charu(int a[]) {
        if (a == null) {
            return;
        }
        int n = a.length;
        if (n <= 1) {
            return;
        }
        int j;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }

    }

    public static void select(int a[]) {
        if (a == null) {
            return;
        }
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {

            int min = a[i];
            int temp = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    temp = j;
                }
            }
            a[temp] = a[i];
            a[i] = min;


        }

    }


    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        select(a);
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
