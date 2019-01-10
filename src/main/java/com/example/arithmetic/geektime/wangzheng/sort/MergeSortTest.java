package com.example.arithmetic.geektime.wangzheng.sort;

import java.util.Arrays;

public class MergeSortTest {


    public static void sort(int a[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a,low,mid,high);

    }

    public static  void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (int n=0;n<temp.length;n++){
            a[low+n]=temp[n];
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};

        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
