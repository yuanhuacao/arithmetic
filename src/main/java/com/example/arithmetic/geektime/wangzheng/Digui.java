package com.example.arithmetic.geektime.wangzheng;

public class Digui {
    /**
     * 倒数10个数
     * @param i
     */
    public  static void countDown(int i){
        if(i>=0){
            System.out.println(i);
            countDown(i-1);
        }else {
            return;
        }
    }

    public  static  int fabonace(int i){

        if (i==1){
            return  1;
        }else {
            return  i*fabonace(i-1);
        }
    }

    public static void main(String[] args) {

        countDown(10);
        System.out.println(fabonace(10));
    }

}
