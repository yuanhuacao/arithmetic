package com.example.arithmetic.geektime.wangzheng;

import java.util.HashMap;
import java.util.Map;

/**
 * 阶梯走法问题
 * 一共N个阶梯，每次可以走一步或者两步。求给定的阶梯N 共有多少走法
 */
public class FloorDG {

    public static Map<Integer, Integer> map = new HashMap();

    public static int ditui(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ret = ditui(n - 1) + ditui(n - 2);
        map.put(n, ret);
        return ret;
    }
    static  int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(ditui(3));
        System.out.println(ditui(4));
        System.out.println(ditui(5));
        System.out.println(ditui(6));
    }

}
