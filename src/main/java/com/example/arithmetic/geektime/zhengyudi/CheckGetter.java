package com.example.arithmetic.geektime.zhengyudi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义注解
 * @Author: 曹远华 (yuanhua.cao@luckincoffee.com)
 * @Date: 2018/12/3 20:12
 */
@Target({ ElementType.TYPE,ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE )
public @interface CheckGetter {

}
