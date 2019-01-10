package com.example.arithmetic.geektime.zhengyudi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parent {

    public void eat(){
        System.out.println("parent eat");
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.execute(()-> System.out.println("111"));
    }
}
