package com.example.arithmetic.geektime.zhengyudi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExceptionTest  {
    public void test() throws  MyException{

    }
    public static void main(String[] args)  {
        File file=new File("aaa");
        ExceptionTest test=new ExceptionTest();
        test.test();
        System.out.println(616%6);
    }
}
