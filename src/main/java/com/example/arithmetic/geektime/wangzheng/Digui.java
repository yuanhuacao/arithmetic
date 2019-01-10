package com.example.arithmetic.geektime.wangzheng;

public class Digui {

	/**
	 * 倒数10个数
	 *
	 * @param i
	 */
	public static void countDown(int i) {
		if (i >= 0) {
			System.out.println(i);
			countDown(i - 1);
		} else {
			return;
		}
	}

	public static int fabonace(int i) {

		if (i == 1) {
			return 1;
		} else {
			return i * fabonace(i - 1);
		}
	}

	public static void main(String[] args) {
		// 这是示例注释，请注意在双斜线之后有一个空格
		countDown(10);
		System.out.println(fabonace(10));
	}

}
