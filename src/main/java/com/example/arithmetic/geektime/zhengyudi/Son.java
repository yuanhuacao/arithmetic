package com.example.arithmetic.geektime.zhengyudi;

public class Son extends  Parent {

    public void  eat(String a){
        System.out.println("son eat");
    }

    public static void main(String[] args) {
        try {
            Parent parent=new Son();
            parent.eat();
        }catch (RuntimeException e){

        }catch (Exception e1){

        }

        Integer a1=127;
        Integer a2=127;
        System.out.println(a1==a2);

    }
}
