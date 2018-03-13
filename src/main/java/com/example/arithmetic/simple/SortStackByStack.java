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


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(1);

        SortStackByStack sortStackByStack=new SortStackByStack();
        Stack help=sortStackByStack.sort(stack);
        while (!help.isEmpty()){
            System.out.println(help.pop());
        }
    }

}
