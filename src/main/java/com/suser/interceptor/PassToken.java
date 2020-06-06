package com.suser.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * PassToken：：：跳过验证的注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}

/***
 * RetentionPolicy.RUNTIME:::这种类型的Annotations将被JVM保留，
 * 所以他们能在运行时被JVM或其他反射机制代码读取和使用
 ***/