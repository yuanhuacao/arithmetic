package com.example.arithmetic.collection;

/**
 * @Description: TODO
 * @Date: 2019/1/14 10:54
 */
public class ArrayListTest {

	public static void main(String[] args) {

		System.out.println(15+(15>>1));
		Integer a=5555555;
		System.out.println(a.hashCode());
		 Integer key=16;
		int h;
		int hash=(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		System.out.println(hash);
		System.out.println("hash"+(15&hash));
		h=0;
		int ha=(h ^ (h >>> 16)) & 0x7fffffff;
		System.out.println("hahah"+ha);

	}

}
