package com.example.arithmetic.mysort;

public class DirectInsertSort {

    public  static  void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for ( j = i - 1; j >= 0; j--) {
                if (a[j]>temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;

        }
    }

    public static void main(String[] args) {
        int a[]={5,4,2,3,8,6,7};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
