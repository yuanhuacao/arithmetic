package com.example.arithmetic.geektime.zhengyudi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Relect {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void i(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class z=Relect.class;
        Method method=z.getMethod("target", int.class);
        for (int i = 0; i <20 ; i++) {
//            method.invoke(null,);

        }
    }
}
