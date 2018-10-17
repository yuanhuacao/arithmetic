package com.example.arithmetic.geektime.zhengyudi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Relect {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class z=Relect.class;
        Method method=z.getMethod("target", int.class);
        method.invoke(null,0);
    }
}
