package com.example.arithmetic.geektime.wangzheng.sort;

import java.util.Arrays;

/**
 * 归并排序
 * merge[p,r]
 * merge[p,q]
 * merge[q+1,r]
 * <p>
 * // 归并排序算法, A 是数组，n 表示数组大小
 * merge_sort(A, n) {
 * merge_sort_c(A, 0, n-1)
 * }
 * <p>
 * // 递归调用函数
 * merge_sort_c(A, p, r) {
 * // 递归终止条件
 * if p >= r  then return
 * <p>
 * // 取 p 到 r 之间的中间位置 q
 * q = (p+r) / 2
 * // 分治递归
 * merge_sort_c(A, p, q)
 * merge_sort_c(A, q+1, r)
 * // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
 * merge(A[p...r], A[p...q], A[q+1...r])
 * }
 */
public class MergeSort {

    public static void merge_sort(int a[], int n) {
        merge_sort_c(a, 0, n - 1);
    }

    public static void merge_sort_c(int a[], int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        merge_sort_c(a, p, q);
        merge_sort_c(a, q + 1, r);
        merge(a,p,q,r);
    }

    /**
     * merge(A[p...r], A[p...q], A[q+1...r]) {
     * var i := p，j := q+1，k := 0 // 初始化变量 i, j, k
     * var tmp := new array[0...r-p] // 申请一个大小跟 A[p...r] 一样的临时数组
     * while i<=q AND j<=r do {
     * if A[i] <= A[j] {
     * tmp[k++] = A[i++] // i++ 等于 i:=i+1
     * } else {
     * tmp[k++] = A[j++]
     * }
     * }
     * <p>
     * // 判断哪个子数组中有剩余的数据
     * var start := i，end := q
     * if j<=r then start := j, end:=r
     * <p>
     * // 将剩余的数据拷贝到临时数组 tmp
     * while start <= end do {
     * tmp[k++] = A[start++]
     * }
     * <p>
     * // 将 tmp 中的数组拷贝回 A[p...r]
     * for i:=0 to r-p do {
     * A[p+i] = tmp[i]
     * }
     * }
     */
    public static void merge(int a[], int p, int q, int r) {
        int temp[] = new int[r - p + 1];
        int i = p;
        int j = q+1;
        int k = 0;
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= q) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + p] = temp[k2];
        }
    }

    // 归并排序的实现
    public static void main(String[] args) {


        int[] nums = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        System.out.println(Arrays.toString(nums));

        merge_sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);
    }
}
