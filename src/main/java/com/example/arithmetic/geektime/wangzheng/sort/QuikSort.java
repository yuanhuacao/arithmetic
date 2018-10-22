package com.example.arithmetic.geektime.wangzheng.sort;

/**
 * 快速排序
 */
public class QuikSort {
    public static void quick(int a[]) {
        if (a.length > 0) {
            quikSort(a,0,a.length-1);
        }
    }

    public static void quikSort(int a[], int low, int high) {
        if (low < high) {
            int midle = getMidlle(a, low, high);
            quikSort(a,0,midle-1);
            quikSort(a,midle+1,high);
        }

    }

    public static int getMidlle(int a[], int low, int high) {
        int privot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[i] < privot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp=a[i];
        a[i]=privot;
        a[high]=temp;
        return  i;
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        // 快速排序
        quick(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
