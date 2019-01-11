package com.example.arithmetic.lru;




import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

	 private ReentrantReadWriteLock reentrantReadWriteLock;


	public LruCache(int cacheSize ){
		super((int)(Math.ceil(cacheSize/0.75)+1),0.75f,true);
		MAX_CACHE_SIZE=cacheSize;
		reentrantReadWriteLock=new ReentrantReadWriteLock();
	}
	@Override
	public boolean removeEldestEntry(Map.Entry eldest){
		return size()>MAX_CACHE_SIZE;
	}
	@Override
	public V get(Object key){
		ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
		try {
			readLock.lock();
			return super.get(key);
		} finally {
			readLock.unlock();
		}
	}
	@Override
	public V put(K k,V v){
		ReentrantReadWriteLock.WriteLock writeLock=reentrantReadWriteLock.writeLock();
		try {
			writeLock.lock();
			return super.put(k,v);
		}finally {
			writeLock.unlock();
		}

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
