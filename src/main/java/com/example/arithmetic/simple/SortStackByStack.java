package com.example.arithmetic.simple;

import java.util.Stack;

/**
 * 用栈为另一个栈排序
 */
public class SortStackByStack {
    private  Stack<Integer> help=new Stack<>();
    public Stack<Integer> sort(Stack<Integer> stack){
        if (stack.isEmpty()){
            return  help;
        }
        int value=stack.pop();
        while (!help.isEmpty()&&value<help.peek()){
            stack.push(help.pop());
        }
        help.push(value);
        this.sort(stack);
        return  help;
    }

    public static  int feibo(int i){
        if (i<1){
            throw  new IllegalArgumentException();
        }
        if (i==1){
            return  1;
        }
        return  i+feibo(i-1);
    }


    public static void main(String[] args) {
        System.out.println(feibo(99));
    }

}
