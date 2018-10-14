package com.example.arithmetic.geektime.zhengyudi;

public class Chongzai {

    void add(Integer a,Integer b){
        System.out.println("integer"+(a+b));
    }
    void add(int a ,int b ){
        System.out.println("int"+(a+b));
    }
    void add(int... a ){
        System.out.println("边长参数"+(a[1]+a[0]));
    }

    public static void main(String[] args) {
        Chongzai chongzai=new Chongzai();
        chongzai.add(1,2);

    }
}
