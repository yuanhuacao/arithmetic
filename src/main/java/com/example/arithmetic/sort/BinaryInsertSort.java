package com.example.arithmetic.sort;

public class BinaryInsertSort {


    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        // 二分插入排序
        sort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 1 2 3 4 5 6 7 3
     * i=7;
     * left=0
     * right=6;
     * midv=3;
     * mid>temp
     * right=mid-1=2
     * mid=1
     * midv=2;
     * midv<temp
     * left=1+1=2;
     * mid=2;
     * midv=3;
     * temp=midv=3
     * right=1;
     * left>right
     * left=2
     *
     * @param a
     */
    private static void sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            a[left] = temp;
        }


    }
}
