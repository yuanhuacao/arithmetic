package com.example.arithmetic.simple;

import java.util.Stack;

/**
 *
 * 获取栈的最小值
 */
public class MinStatck {

    private Stack dataStack=new Stack();
    private Stack minStack=new Stack();

    public void push (Integer a){
        dataStack.push(a);
        if (minStack.isEmpty()){
                minStack.push(a);
        }else {
            if (a<=(int)minStack.peek()){
                    minStack.push(a);
            }
        }
    }

    public int   pop(){
        int value=(int)dataStack.pop();
        int min=(int)minStack.peek();
        if (value<=min){
            minStack.pop();
        }
        return  value;
    }

    public int getMin(){
        return  (int)minStack.peek();
    }

    public static void main(String[] args) {
        MinStatck minStatck=new MinStatck();
        minStatck.push(3);
        minStatck.push(5);
        minStatck.push(2);
        minStatck.push(4);
        minStatck.push(1);
        System.out.println(minStatck.pop());
        System.out.println(minStatck.pop());
        System.out.println(minStatck.getMin());
    }


}
