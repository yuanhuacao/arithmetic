package com.example.arithmetic.bitmap;

import com.google.common.hash.BloomFilter;
import com.sun.tools.javac.util.Bits;

public class TestMyBloomFilter {

    private final String[] URLS = {
            "http://www.csdn.net/",
            "http://www.baidu.com/",
            "http://www.google.com.hk",
            "http://www.cnblogs.com/",
            "http://www.zhihu.com/",
            "https://www.shiyanlou.com/",
            "http://www.google.com.hk",
            "https://www.shiyanlou.com/",
            "http://www.csdn.net/"
    };

    private void testBloomFilter() {
        MyBloomFilter filter = new MyBloomFilter();
        for (int i = 0; i < URLS.length; i++) {
            if (filter.contains(URLS[i])) {
                System.out.println("contain: " + URLS[i]);
                continue;
            }

            filter.add(URLS[i]);
        }
    }

    public static void main(String[] args) {
        Long i=1l;
        Integer j=10;
        System.out.println(i<<63);
        System.out.println(i<<128);

        TestMyBloomFilter t = new TestMyBloomFilter();
        t.testBloomFilter();
    }

}
