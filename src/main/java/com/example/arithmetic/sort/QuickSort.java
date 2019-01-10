package com.example.arithmetic.sort;

public class QuickSort {


    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        // 快速排序
        quick(a, 0, a.length - 1);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void quick(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int midle = getMidlle(a, low, high);
        quick(a, low, midle - 1);
        quick(a, midle + 1, high);

    }

    public static int getMidlle(int[] a, int low, int high) {
        int privot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] < privot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = privot;
        a[high] = temp;

        return i;

    }

    /**
     * partition(A, p, r) {
     * pivot := A[r]
     * i := p
     * for j := p to r-1 do {
     * if A[j] < pivot {
     * swap A[i] with A[j]
     * i := i+1
     * }
     * }
     * swap A[i] with A[r]
     * return i
     *
     * @param a
     * @param low
     * @param high
     * @return
     */


}
