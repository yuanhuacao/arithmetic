package com.example.arithmetic.geektime.wangzheng.sort;

public class BubleSort {

    public static void sort(int[] a) {
        int n = a.length;
        if (n <= 0) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = a[j];
                if (a[j] > a[j + 1]) {
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
        }
        if (!flag) {
            return;
        }

    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        sort(a);
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
