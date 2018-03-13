package com.example.arithmetic.simple;

import java.util.Stack;

/**
 *
 * 获取栈的最小值
 * 算法都为 N(1)
 */
public class MinStatck2 {

    private Stack dataStack=new Stack();
    private Stack minStack=new Stack();

    public void push (Integer a){
        dataStack.push(a);
        if (minStack.isEmpty()){
                minStack.push(a);
        }else {
            int min=(int)minStack.peek();
            if (a<=min){
                    minStack.push(a);
            }else {
                minStack.push(min);
            }
        }
    }

    public int   pop(){
        minStack.pop();
        return  (int)dataStack.pop();
    }

    public int getMin(){
        return  (int)minStack.peek();
    }

    public static void main(String[] args) {
        MinStatck2 minStatck=new MinStatck2();
        minStatck.push(3);
        minStatck.push(5);
        minStatck.push(2);
        minStatck.push(1);
        minStatck.push(4);
        minStatck.push(1);
        minStatck.push(1);
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.getMin());
    }


}
