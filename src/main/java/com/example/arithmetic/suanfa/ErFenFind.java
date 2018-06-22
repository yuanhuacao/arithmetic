package com.example.arithmetic.suanfa;

public class ErFenFind {
    static int num = 0;

    public static int find(int[] numbers, int goal, int mid, int length) {

        System.out.println("第" + (++num) + "次查找");
        if (goal == numbers[mid]) {
            return mid;
        }
        //后半区
        if (goal > numbers[mid]) {
            mid = (mid + length) / 2;
        } else {
            length = mid;
            mid = mid / 2;
        }
        return find(numbers, goal, mid, length);
    }

    public static void main(String[] args) {
        int[] num = {2, 4, 7, 12, 34, 56, 90, 678};
        System.out.println(find(num, 678, num.length / 2, num.length));
    }


}
