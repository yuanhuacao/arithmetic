package com.example.arithmetic.simple;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * 用栈实现队列
 */
public class MyQune {
    Stack stackPush=new Stack();
    Stack stackPop=new Stack();
    public  void add (Object o){
        stackPush.push(o);
    }
    public Object poll(){
        if (stackPop.isEmpty()&&!stackPush.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public Object peek(){
        if (stackPop.isEmpty()&&!stackPush.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        MyQune myQune=new MyQune();
        myQune.add("a");
        myQune.add("b");
        myQune.add("c");
        System.out.println(myQune.poll());
        myQune.add(1);
        myQune.add(2);
        myQune.add(3);
        System.out.println(myQune.poll());
        System.out.println(myQune.peek());
        System.out.println(myQune.peek());
        Queue queue=new ConcurrentLinkedQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());



    }

}
