package com.example.arithmetic.structure;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MasTest {

    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        long start=System.currentTimeMillis();
        for ( int i=0;i<10000000;i++){
            map.put(i,i+"->map");
        }

        long end=System.currentTimeMillis();
        //第二种迭代器
        Iterator<Map.Entry<Integer,String>> iterator2=map.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry<Integer,String> entry=iterator2.next();
            entry.getValue();
            entry.getKey();
        }
        long end5=System.currentTimeMillis();
        System.out.println("迭代entry"+(end5-end));


        //for 循环
        for (Integer key:map.keySet()){
            map.get(key);

        }
        long end2=System.currentTimeMillis();
        System.out.println("for time "+(end2-end));

        //entry for
        for (Map.Entry entry:map.entrySet()){
            entry.getKey();
            entry.getValue();
        }
        long end3=System.currentTimeMillis();
        System.out.println("entry for time  "+(end3-end2));

        //第一种迭代器
        Iterator<Integer> iterator=map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key=iterator.next();
            map.get(key);
        }
        long end4=System.currentTimeMillis();
        System.out.println("第一种迭代器  "+(end4-end3));



















    }

}
