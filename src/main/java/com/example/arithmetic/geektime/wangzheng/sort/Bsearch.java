package com.example.arithmetic.geektime.wangzheng.sort;

import java.util.Arrays;

public class Bsearch {


    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int bsearch(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        }
        if (a[mid] > value) {
            return bsearch(a, low, mid - 1, value);
        } else {
            return bsearch(a, mid + 1, high, value);
        }


    }


    // 归并排序的实现
    public static void main(String[] args) {


        int[] nums = {2, 6, 7, 12, 45, 65, 89};
        int index = bsearch(nums, 0, nums.length, 65);
        System.out.println(index);
    }
}
