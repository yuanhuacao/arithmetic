package com.example.arithmetic.structure;

import java.util.Stack;

public class CalculateExpression {


    /**
     * 中缀转后缀
     *
     * @param expstr 中缀表达式字符串
     * @return
     */
    public static String toPostfix(String expstr) {
        //创建栈,用于存储运算符
        Stack<String> stack = new Stack<>();

        String postfix = "";//存储后缀表达式的字符串
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    //当栈不为空或者栈顶元素不是左括号时,直接出栈,因此此时只有可能是*/+-四种运算符(根据规则4),否则入栈
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix += stack.pop();
                    }
                    //入栈
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    //遇到运算符*/
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    //左括号直接入栈
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    //遇到右括号(规则3)
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix += out;
                        out = stack.pop();
                    }
                    i++;
                    break;
                default:
                    //操作数直接拼接
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length())
                            ch = expstr.charAt(i);
                        else
                            ch = '=';
                    }
                    //分隔符
                    postfix += " ";
                    break;
            }
        }
        //最后把所有运算符出栈(规则5)
        while (!stack.isEmpty())
            postfix += stack.pop();
        return postfix;
    }

    public static String myToPostfix(String expstr) {
        String postfix = null;
        //创建栈,用于存储运算符和括号
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expstr.length(); i++) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    //当栈不为空或者栈顶元素不是左括号时,直接出栈,因此此时只有可能是*/+-四种运算符(根据规则4),否则入栈
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    break;
                case '(':
                    stack.push(ch + "");
                    break;
                case ')':
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix += out;
                        out = stack.pop();
                    }
                    break;
                default:
                    //操作数直接拼接
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        if (i < expstr.length())
                            ch = expstr.charAt(i);
                        else
                            ch = '=';
                    }
                    //分隔符
                    postfix += " ";
                    break;
            }

        }


        return postfix;

    }

    /**
     * 计算后缀表达式的值
     *
     * @param postfix 传入后缀表达式
     * @return
     */
    public static int calculatePostfixValue(String postfix) {
        //栈用于存储操作数,协助运算
        Stack<Integer> stack = new Stack<>();
        int i = 0, result = 0;
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = 0;
                while (ch != ' ') {
                    //将整数字符转为整数值ch=90
                    result = result * 10 + Integer.parseInt(ch + "");
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                stack.push(result);//操作数入栈
            } else {  //ch 是运算符,出栈栈顶的前两个元素
                int y = stack.pop();
                int x = stack.pop();
                switch (ch) {   //根据情况进行计算
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;   //注意这里并没去判断除数是否为0的情况
                }
                //将运算结果入栈
                stack.push(result);
                i++;
            }
        }
        //将最后的结果出栈并返回
        return stack.pop();
    }

    //测试
    public static void main(String args[]) {
        String expstr = "1+(2-3)*(4+5)";
        String postfix = toPostfix(expstr);
        System.out.println("中缀表达式->expstr=  " + expstr);
        System.out.println("后缀表达式->postfix= " + postfix);
        System.out.println("计算结果->value= " + calculatePostfixValue(postfix));
    }

}
