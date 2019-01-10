package com.example.arithmetic.geektime.wangzheng.sort;

import com.example.arithmetic.simple.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTest {


    /**
     *  int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     * @param args
     */
    public static void main(String[] args) {
        // key.hashCode()) ^ (h >>> 16)
        HashMap hashMap=new HashMap();
        hashMap.put("a","b");
        Set<Map.Entry>  entries=hashMap.entrySet();

        for (Map.Entry entry: entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("-----------分割线---------");

        System.out.println(7&672341);
    }
}
