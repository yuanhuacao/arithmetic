package com.example.arithmetic.simple;

import java.util.LinkedList;

/**
 * 最大窗口滑动
 * 1234
 * 2,3,4
 * 4312
 * 1324
 * 334
 * 4-2+1=3
 * 4321
 * 56874
 * j
 * 123456
 * <p>
 * 相当难以理解啊
 *
 * 双端队列中对多保存 W 个值
 * 比较难以理解 啊啊啊
 */
public class MaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        LinkedList<Integer> maxQ = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!maxQ.isEmpty() && arr[maxQ.peekLast()] <= arr[i]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);
            if (maxQ.peekFirst() == i - w) {
                maxQ.pollFirst();
            }

            if (i >= w - 1) {
                result[index++] = arr[maxQ.peekFirst()];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        MaxWindow maxWindow = new MaxWindow();
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] reult = maxWindow.getMaxWindow(arr, 3);
        for (int i : reult
                ) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
