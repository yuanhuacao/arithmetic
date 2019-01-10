package com.example.arithmetic.geektime.zhengyudi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: geeker (geek)
 * @Date: 2018/12/5 21:36
 */
@Component public class GcTest implements CommandLineRunner {

	private Map map = new HashMap();
	Byte[] bytes = new Byte[1024 * 1024];
	int i = 0;

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 1000; i++) {
			Thread.sleep( 1000);
			new Foo();
			map.put(i++, bytes);
		}

	}
}
