package com.example.arithmetic.geektime.zhengyudi;

public class JavaPTest {

    public static int bar(int i) {
        return ((i + 1) - 2) * 3 / 4;
    }
//// 对应的字节码如下：
//    Code:
//    stack=2, locals=1, args_size=1
//            0: iload_0
//     1: iconst_1
//     2: iadd
//     3: iconst_2
//     4: isub
//     5: iconst_3
//     6: imul
//     7: iconst_4
//     8: idiv
//     9: ireturn

}
