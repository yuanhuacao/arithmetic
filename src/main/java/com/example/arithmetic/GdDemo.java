package com.example.arithmetic;
import cebenc.softenc.SoftEnc;

import java.util.*;
import java.util.stream.Collectors;

public class GdDemo {

    public static void main(String[] args) {
        List t =GdDemo.sort("abbbbbbbbfffeeeeeeeeejj");
        System.out.println(t.toString());
    }
    public static List<String> sort(String str){
        char[] chars=str.toCharArray();
        HashMap<String,Integer> map=new HashMap<>(100);
        for (char c:chars){
            String temp=String.valueOf(c);
            if (map.containsKey(temp)){
                Integer count=map.get(temp);
                map.put(temp,++count);
            }else {
                map.put(temp,1);
            }
        }
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getValue()+":"+entry.getKey());
        }
        List<String> list=map.entrySet().stream().sorted((x,y)->x.getValue().compareTo(y.getValue())).map(x->x.getKey()).collect(Collectors.toList());
        return list;

    }
}
