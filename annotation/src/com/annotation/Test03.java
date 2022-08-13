package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //注解可以显示赋值，如果没有默认值，就需要赋值
    @MyAnnotation2(name = "贺晋尧",schools = {"四川大学","电子科技大学"})
    public void test(){
    }
    @MyAnnotation3("贺晋尧")
    public void test2(){}
}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名();
    String name() default "";
    int age() default 1;
    int id() default -1;//默认值为-1表示不存在

    String[] schools();
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}