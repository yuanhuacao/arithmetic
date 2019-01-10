package com.example.arithmetic.lru;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: geeker (geek)
 * @Date: 2019/1/9 18:08
 */
public class LRUCache {

	public static void main(String[] args) {

		Map<Object,Object> map=new HashMap<>(2);
		map.put("小明",1);
		Object obj=map.put("abc大王",2);
		System.out.println("obj="+obj);
		map.put("思密达",3);
		map.put("jack",4);
		map.put("马斯克",6);
		map.put(7,7);
		map.put(8,8);
		map.put(9,9);
		for (Map.Entry entry: map.entrySet()){
			System.out.println(entry.getKey());

		}

	}

}
