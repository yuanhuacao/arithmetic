package com.example.arithmetic.geektime.zhengyudi;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author qiang.xie
 * @date 2017/4/14
 */
public class MethodHandlerTest {

    public static void main(String[] arg) throws Throwable {
        //获取方法f1的methodType对象，表示此方法的返回值类型和参数类型
        MethodType f1 = MethodType.methodType(String.class, int.class);
        MethodType f2 = MethodType.methodType(void.class);//无参数，返回值是void的方法
        MethodType f3 = MethodType.methodType(void.class);

        //通过MethodHandles.lookup()可以在一个类上根据方法名称和方法的methodType获取方法句柄
        //查找普通方法
        MethodHandle mf1 = MethodHandles.lookup().findVirtual(MethodHandlerTest.class, "f1", f1);
        MethodHandle mf2 = MethodHandles.lookup().findVirtual(MethodHandlerTest.class, "f2", f2);

        //查找静态方法
        MethodHandle mf3 = MethodHandles.lookup().findStatic(MethodHandlerTest.class, "f3", f3);
        //通过方法句柄调用方法
        MethodHandlerTest methodHandler = new MethodHandlerTest();
        mf1.invoke(methodHandler, 123);
        mf2.invoke(methodHandler);

        //使用invokeExact调用时，参数类型和返回值类型必须与方法签名的一致
        String v = (String) mf1.invokeExact(methodHandler, 1234);

        //调用静态方法
        mf3.invoke();
    }


    public String f1(int a) {
        System.out.println("f1" + a);
        return a + "";
    }

    public void f2() {
        System.out.println("f2");
    }

    public static void f3() {
        System.out.println("f3");

    }
}