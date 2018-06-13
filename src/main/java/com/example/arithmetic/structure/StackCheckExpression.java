package com.example.arithmetic.structure;

import java.util.Stack;

public class StackCheckExpression {


    public static String isValid(String expstr) {
        //创建栈
        Stack<String> stack = new Stack<>();
        int i=0;
        for (char a : expstr.toCharArray()) {
            System.out.println("i="+i);
            if (a == '(') {
                stack.push(a + "");
            } else if (a == ')') {
                if (stack.isEmpty()) {
                    return ")";
                }
                stack.pop();
            }
            i++;
        }


        //最后检测是否为空,为空则检测通过
        if (stack.isEmpty())
            return "check pass!";
        else
            return "(";
    }

    public static void main(String[] args) {
        System.out.println(StackCheckExpression.isValid(")"));
    }


}
