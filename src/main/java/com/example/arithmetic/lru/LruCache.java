package com.example.arithmetic.lru;


import com.sun.jdi.request.MethodEntryRequest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: geeker (geek)
 * @Date: 2019/1/9 18:08
 */
public class LruCache<K,V> extends LinkedHashMap<K,V> {

	/**
	 * 缓存最大容量
	 */
	 private   static int  MAX_CACHE_SIZE=100;

	public LruCache(int cacheSize ){
		super(cacheSize,0.75f,true);
		MAX_CACHE_SIZE=cacheSize;
	}
	@Override
	public boolean removeEldestEntry(Map.Entry eldest){
		return size()>MAX_CACHE_SIZE;
	}
	public static  void main(String[] args){
		LruCache<Integer,Integer> lruCache=new LruCache(3);
		lruCache.put(1,1);
		lruCache.put(2,1);
		lruCache.put(3,1);
		lruCache.get(1);
		lruCache.put(4,1);

		for (Map.Entry entry:lruCache.entrySet()){
			System.out.println(entry.getKey());
		}

	}
}
