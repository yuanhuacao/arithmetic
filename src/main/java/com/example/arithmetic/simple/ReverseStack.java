package com.example.arithmetic.simple;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * 用递归函数逆排序一个栈
 * 比较难了，呵呵 递归递归弟子规
 */
public class ReverseStack {

    public int getLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = this.getLastElement(stack);
        stack.push(result);
        return last;

    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getLastElement(stack);
        this.reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
