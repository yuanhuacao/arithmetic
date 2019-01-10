package com.example.arithmetic.geektime.wangzheng.sort;

/**
 * 二分查找的变形
 */
public class BserchB {


    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (a[low] == value) return low;
        else return -1;
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
//        int index = bsearch(a, a.length, 8);
        int[] nums = {2, 6, 7, 12, 45, 65, 89};
        int index = bsearch(nums, nums.length, 65);
        System.out.println(index);

    }

}
