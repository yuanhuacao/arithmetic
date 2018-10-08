package com.example.arithmetic.mysort;

public class BiInsertSort {

    public static void sort(int[] a) {
        for (int k = 1; k < a.length; k++) {

            int temp = a[k];
            int left = 0;
            int right = k - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (a[mid] >temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int j = k - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            a[left] = temp;
        }
    }

    public static void main(String[] args) {

        int a[] = {3, 1, 4, 7, 9, 2, 3, 6, 5};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }



    }

}
